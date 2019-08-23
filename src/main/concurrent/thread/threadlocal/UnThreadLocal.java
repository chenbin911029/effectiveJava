package main.concurrent.thread.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 未使用ThreadLocal,锁，并发控制，多个线程访问共享数据
 * Created by chenbin on 2019\8\22 0022.
 */
public class UnThreadLocal {
    //SimpleDateFormat 被多线程访问
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static class ParseDate implements Runnable {
        int i = 0;
        public ParseDate(int i) {
            this.i = i;
        }

        public void run() {
            try {
                Date t = sdf.parse("2019-08-22 17:29:"+i%60);
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
