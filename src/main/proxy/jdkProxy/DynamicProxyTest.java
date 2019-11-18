package main.proxy.jdkProxy;

/**
 * Created by chenbin on 2019\9\29 0029.
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        // 保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();
        /**
         * 动态代理类（基于接口实现）
         * 在程序运行时创建的代理模式。
         * 跟静态代理相比，动态代理的优势在于可以很方便的对代理类的函数
         * 进行统一的处理，不需要修改每个代理类中的方法。
         */
    }
}
