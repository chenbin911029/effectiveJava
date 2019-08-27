package main.concurrent.thread;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoin框架使用demo
 * Created by chenbin on 2019\8\21 0021.
 */
public class ForkJoinPoolDemo extends RecursiveTask<Long> {
    private static final int THRESHOLD = 10000;
    private long start;
    private long end;

    public ForkJoinPoolDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (long i = start;i <= end;i++) {
                sum +=i;
            }
        } else {
            //分成100个小任务
            long step = (start + end)/100;
            ArrayList<ForkJoinPoolDemo> subTasks = new ArrayList<ForkJoinPoolDemo>();
            long pos = start;
            for (int i = 0;i < 100;i++) {
                long lastOne = pos + step;
                if (lastOne > end) {
                    lastOne = end;
                }
                ForkJoinPoolDemo subTask = new ForkJoinPoolDemo(pos,lastOne);
                pos += step + 1;
                subTasks.add(subTask);
                subTask.fork();
            }
            for(ForkJoinPoolDemo t : subTasks) {
                sum += t.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinPoolDemo task = new ForkJoinPoolDemo(0,200000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        try {
            long res = result.get();
            System.out.println("sum="+res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
