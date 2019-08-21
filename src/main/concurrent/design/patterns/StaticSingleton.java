package main.concurrent.design.patterns;

/**
 * Created by chenbin on 2019\8\21 0021.
 */
public class StaticSingleton {
    private StaticSingleton() {}

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
