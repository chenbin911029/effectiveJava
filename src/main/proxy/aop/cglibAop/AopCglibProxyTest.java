package main.proxy.aop.cglibAop;

import org.junit.Test;

/**
 * 基于动态代理类AOP测试案例
 * Created by chenbin on 2019\11\18 0018.
 */
public class AopCglibProxyTest {
    @Test
    public void cglibTest() {
        System.out.println("before Proxy......");
        UserServiceImpl userService = new UserServiceImpl();
        userService.saveUser("zby", "1234567890");
        System.out.println("引入Cglib  Proxy代理库 后......");

        UserServiceImpl proxyUser = (UserServiceImpl)CglibProxyGenerator
                .generatorCglibProxy(userService,new CustomAspect());
        proxyUser.saveUser("zby", "1234567890");
    }
}
