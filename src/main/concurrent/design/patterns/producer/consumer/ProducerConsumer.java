package main.concurrent.design.patterns.producer.consumer;

/**
 * 生产者消费者，测试主函数
 * Created by chenbin on 2019\8\21 0021.
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        SyncStack ss = new SyncStack();
        Producer p = new Producer(ss);
        Consumer c = new Consumer(ss);

        new Thread(p).start();
        new Thread(c).start();
    }
}
