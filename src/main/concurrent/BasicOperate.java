package main.concurrent;

/**
 * Created by chenbin on 2019\3\26 0026.
 */
public class BasicOperate {

    private final static Object object = new Object();

    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.start();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        T2 t2 = new T2();
        t2.start();
    }

    public static class T1 extends Thread {
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T1 start! ");
                try {
                    System.out.println(System.currentTimeMillis()
                            + ":T1 wait for object ");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":T1 end!");
            }
        }
    }

    public static class T2 extends Thread{
        public void run()
        {
            synchronized (object) {
                System.out.println(System.currentTimeMillis()
                        +":T2 start! notify one thread");
                object.notify();
                System.out.println(System.currentTimeMillis()+":T2 end!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
