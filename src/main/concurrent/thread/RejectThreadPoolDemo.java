package main.concurrent.thread;

import java.util.concurrent.*;

/**
 * 线程池使用demo
 * Created by chenbin on 2019\8\19 0019.
 */
public class RejectThreadPoolDemo {
    public static class MyTask implements Runnable {
        public String name;

        public MyTask(String name) {
            this.name = name;
        }

        public void run() {
            System.out.println("正在执行，"
                    + System.currentTimeMillis()
                    + ":Thread ID:" + Thread.currentThread().getId()
                    + "，Task Name=" + name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(5,
                5,
                0L,
                TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString()+"is discard.");
                    }
                });

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            MyTask task = new MyTask("task-name-"+i);
            es.execute(task);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        es.shutdown();
    }
}
