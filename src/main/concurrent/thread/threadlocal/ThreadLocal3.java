package main.concurrent.thread.threadlocal;

/**
 *
 * Created by chenbin on 2019\8\22 0022.
 */
public class ThreadLocal3 {
    //SimpleDateFormat 被多线程访问
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static class ParseDate implements Runnable {
        String str;
        public ParseDate(String str) {
            this.str = str;
        }

        public void run() {
            try {
                if (threadLocal.get() == null) {
                    //为每个线程分配一个实例
                    threadLocal.set(str);
                }

                System.out.println(Thread.currentThread().getName()+ ":str:" + threadLocal.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0;i < 1000;i++) {
            String name = String.valueOf(i);
            Thread t = new Thread( new ParseDate(name));
            t.setName(name);
            t.start();
        }
    }
}
