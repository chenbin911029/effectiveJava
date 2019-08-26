package main.concurrent.jdk8;

import java.util.concurrent.locks.StampedLock;

public class StampLockDemo3 {

    private int balance;

    private StampedLock lock = new StampedLock();
    public StampLockDemo3() {
        balance=10;
    }

    public void optimisticRead() {
        long stamp = lock.tryOptimisticRead();
        int c = balance;
        // 这里可能会出现了写操作，因此要进行判断
        if(!lock.validate(stamp)) {
            // 要重新读取
            System.out.println("要重新读取");
            stamp = lock.readLock();
            try{
                c = balance;
            }
            finally{
                lock.unlockRead(stamp);
            }
        }
        System.out.println("读取的值为:"+c);
    }

    public void write(int value) {
        long stamp = lock.writeLock();
        balance += value;
        lock.unlockWrite(stamp);
    }


    public static void main(String[] args) {
        StampLockDemo3 demo=new StampLockDemo3();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    demo.optimisticRead();
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
                while(true){
                    demo.write(2);
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
