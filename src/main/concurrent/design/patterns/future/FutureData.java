package main.concurrent.design.patterns.future;

/**
 * Created by chenbin on 2019\8\21 0021.
 */
public class FutureData implements Data {
    protected RealData realData = null;
    protected boolean isReady = false;

    public synchronized void setRealData(RealData realData){
        if (isReady) {
            return;
        }
        this.realData = realData;
        isReady = true;
        notifyAll();
    }

    public synchronized String getResult() {
        while(!isReady) {
            try {
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.getResult();
    }
}
