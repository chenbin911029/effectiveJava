package main.proxy.staticProxy;

/**
 * 静态代理测试类
 * Created by chenbin on 2019\11\15 0015.
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        Sing sing = new Sing();
        ISing proxy = new StaticProxy(sing);
        proxy.folkMusic();
    }
    /**
     * 静态代理
     * 一个公共接口，一个委托类，一个代理类
     * 代理模式就是在访问实际对象时引入一定程度的间接性，因为这种间接性
     * 可以附加多种用途。例如前置通知，后置通知。
     * 代理类存在的意义就是为了增加一些公共代码逻辑
     */
}
