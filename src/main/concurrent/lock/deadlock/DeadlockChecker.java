package main.concurrent.lock.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by chenbin on 2019\8\18 0018.
 */
public class DeadlockChecker {
    private final static ThreadMXBean mbean = ManagementFactory.getThreadMXBean();
    final static Runnable deadlockCheck = new Runnable() {
        public void run() {
            while (true) {
                long[] deadlockThreadIds = mbean.findDeadlockedThreads();
                if (deadlockThreadIds != null) {
                    ThreadInfo[] threadInfos = mbean.getThreadInfo(deadlockThreadIds);
                    for (Thread t : Thread.getAllStackTraces().keySet()) {
                        for (int i = 0;i < threadInfos.length;i++) {
                            if (t.getId() == threadInfos[i].getThreadId()) {
                                t.interrupt();
                            }
                        }

                    }
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {

                }
            }
        }
    };

    public static void check() {
        Thread t = new Thread(deadlockCheck);
        t.setDaemon(true);
        t.start();
    }
}
