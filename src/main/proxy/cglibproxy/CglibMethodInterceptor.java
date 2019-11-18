package main.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by chenbin on 2019\11\18 0018.
 */
public class CglibMethodInterceptor implements MethodInterceptor {

    /**
     * 用于生成Cglib动态代理类
     * @param target 被代理的委托类的Class对象
     * @return
     */
    public Object cglibProxyGenerator(Class target) {
        //创建加强类，用来创建动态代理类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     *
     * @param o 代表Cglib生成的动态代理类，对象本身
     * @param method 代理类中被拦截的接口方法 Method实例
     * @param objects 接口方法参数
     * @param methodProxy 用于调用父类真正的业务类方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method.");
        MonitorUtil.start();
        Object result = methodProxy.invokeSuper(o,objects);
        MonitorUtil.finish(method.getName());
        System.out.println("after method.");
        return result;
    }
}
