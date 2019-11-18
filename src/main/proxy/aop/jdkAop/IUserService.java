package main.proxy.aop.jdkAop;

/**
 * @description: 定义切点角色接口 因为是基于JDK实现的Aop ，所以委托类需要基于接口实现
 * Created by chenbin on 2019\11\18 0018.
 */
public interface IUserService {
    void saveUser(String username, String password);
}
