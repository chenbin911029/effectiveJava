package main.concurrent.design.patterns.future;

/**
 * 调用future模式客户端
 * 1.request(str)方法会先返回一个假数据futureData
 * 2.另起一个线程去计算realData，计算完成后把结果赋值给futureData对象
 * Created by chenbin on 2019\8\21 0021.
 */
public class Client {
    public Data request(final String str) {
        final FutureData futureData = new FutureData();
        new Thread(new Runnable() {
            public void run() {
                //RealData构造缓慢，所以放在独立的线程中运行
                RealData realData = new RealData(str);
                futureData.setRealData(realData);
            }
        }).start();

        //先直接返回FutureData
        return futureData;
    }
}
