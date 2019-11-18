package main.proxy.aop.jdkAop;

/**
 * @Description： UserService接口实现类UserServiceImpl
 * 该类 作为AOP中切点角色，切面定义的方法插入到切点的接口方法
 * Created by chenbin on 2019\11\18 0018.
 */
public class UserServiceImpl implements IUserService{
    @Override
    public void saveUser(String username, String password) {
        System.out.println("save user[username=" + username + ",password=" + password + "]");
    }
}
