package main.proxy.aop.cglibAop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description: 基于Cglib代理类生成器工具类
 * Created by chenbin on 2019\11\18 0018.
 */
public class CglibProxyGenerator {
    public static Object generatorCglibProxy(final Object target,final IAspect aspect) {
        Enhancer enhancer = new Enhancer();
        //3.2 设置需要代理的父类
        enhancer.setSuperclass(target.getClass());
        //3.3 设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
                    throws Throwable {
                // 执行切面方法
                aspect.startTransaction();
                Object result = methodProxy.invokeSuper(o,objects);
                aspect.endTransaction();
                return result;
            }
        });
        //创建代理对象
        return enhancer.create();
    }
}
