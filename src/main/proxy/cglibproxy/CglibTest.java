package main.proxy.cglibproxy;

import org.junit.Test;

/**
 * Created by chenbin on 2019\11\18 0018.
 */
public class CglibTest {
    @Test
    public void testCglib() {
        CglibMethodInterceptor interceptor = new CglibMethodInterceptor();
        //生成 Football 的代理类
        Football subFootball = (Football) interceptor.cglibProxyGenerator(Football.class);
        subFootball.play();
    }

    /**
     * cglib总结：
     * 1.CGlib可以传入接口也可以传入普通的类，接口使用实现的方式，普通类使用继承的方式生成代理类。
     * 2.由于是继承方式，如果是static方法，private方法，final方法等描述的方法是不能被代理的。
     * 3.做了方法方位优化，使用建立方法索引的方式避免了传统jdk动态代理要通过method方法反射调用。
     * 4.提供callback，和filter设计，可以灵活地给不同的方法绑定不同的callback。
     * 5.CGlib会默认代理Object中的equals，toString，hashCode，clone等方法。比JDK代理多了clone.
     */
}
