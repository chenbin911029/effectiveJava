package main.proxy.aop.jdkAop;

        import org.junit.Test;

/**
 * @Description： 基于动态代理类AOP测试案例
 * Created by chenbin on 2019\11\18 0018.
 */
public class AopJDKProxyTest {
    @Test
    public void testAopJdkProxy() {
        System.out.println("无代理前 调用方法 userService.saveUser 输出......");
        IUserService userService = new UserServiceImpl();
        userService.saveUser("zby", "1234567890");

        System.out.println("有代理后AOP 是怎么样的？ Proxy......");
        IUserService proxyUserService = (IUserService)JDKDynamicProxyGenerator
                .generatorJDKProxy(userService,new CustomAspect());
        proxyUserService.saveUser("zby", "1234567890");
        proxyUserService.saveUser(null,null);
    }
}
