package main.concurrent.jdk8;

import java.util.concurrent.locks.StampedLock;

/**
 * 读写锁的改进，读不阻塞写
 * Created by chenbin on 2019\8\24 0024.
 */
public class StampLockDemo {
    private double x=10,y=10;
    private final StampedLock lock = new StampedLock();

    public void move(double deltaX,double deltaY) {
        //an exclusively locked method
        long stamp = lock.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            lock.unlock(stamp);
        }
        System.out.println("写后的值x:"+x+"y:"+y);
    }

    public double distanceFromOrigin() {
        //a read-only method
        long stamp = lock.tryOptimisticRead();
        double currentX = x;
        double currentY = y;

        //若其它线程发生了写操作，则会改变stamp,所以验证时间戳
        if (!lock.validate(stamp)) {
            System.out.println("其它线程发生写操作。");
            //重读之前获取读锁
            stamp = lock.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                lock.unlock(stamp);
            }
        }
        System.out.println("读取的值x:"+x+"y:"+y);
        return Math.sqrt(currentX * currentX + currentY*currentY);
    }


    public static void main(String[] args) {
        StampLockDemo stampLockDemo = new StampLockDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    stampLockDemo.move(10,10);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    stampLockDemo.distanceFromOrigin();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
