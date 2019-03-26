package main.concurrent;

/**
 * Created by chenbin on 2019\3\26 0026.
 */
public class Visibility extends Thread {
    private boolean stop;
    public void run() {
        int i = 0;
        while(!stop) {
            i++;
        }
        System.out.println("finish loop,i=" + i);
    }
    public void stopIt() {
        stop = true;
    }
    public boolean getStop(){
        return stop;
    }

    public static void main(String[] args) throws Exception {
        Visibility v = new Visibility();
        v.start();
        Thread.sleep(1000);
        v.stopIt();
        Thread.sleep(2000);
        System.out.println("finish main");
        System.out.println(v.getStop());
    }
}
