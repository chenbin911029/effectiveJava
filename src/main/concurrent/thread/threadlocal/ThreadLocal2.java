package main.concurrent.thread.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用ThreadLocal,每个线程都有自己的SimpleDateFormat实例
 * Created by chenbin on 2019\8\22 0022.
 */
public class ThreadLocal2 {
    private static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>();

    public static class ParseDate implements Runnable {
        int i = 0;
        public ParseDate(int i) {
            this.i = i;
        }

        public void run() {
            try {
                if (tl.get() == null) {
                    //为每个线程分配一个实例
                    tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }
                Date t = tl.get().parse("2019-08-22 17:29:"+i%60);
                System.out.println(i+":"+t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0;i < 1000;i++) {
            es.execute(new ParseDate(i));
        }
    }
}
