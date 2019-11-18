package main.proxy.jdkProxy;

/**
 * 需要增强的目标类，target
 * Created by chenbin on 2019\11\15 0015.
 */
public class Hello implements IHello {
    @Override
    public void sayHello() {
        System.out.println("hello world.");
    }
}
