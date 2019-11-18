package main.proxy.staticProxy;

/**
 * 静态代理类
 * Created by chenbin on 2019\11\15 0015.
 */
public class StaticProxy implements ISing {

    private Sing sing;

    public StaticProxy() {}

    public StaticProxy(Sing sing) {
        this.sing = sing;
    }

    @Override
    public void folkMusic() {
        System.out.println("StaticProxy before sing.");
        sing.folkMusic();
        System.out.println("StaticProxy after sing.");
    }
}
