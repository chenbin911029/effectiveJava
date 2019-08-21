package main.concurrent.design.patterns.future;

/**
 * Created by chenbin on 2019\8\21 0021.
 */
public interface Data {
    String getResult() throws InterruptedException;
}
