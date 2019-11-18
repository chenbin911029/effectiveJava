package main.proxy.aop.cglibAop;

/**
 * @description: 业务实现类UserServiceImpl 该类 作为AOP中切点角色
 * Created by chenbin on 2019\11\18 0018.
 */
public class UserServiceImpl {
    public void saveUser(String username, String password) {
        System.out.println("cglib save user[username=" + username + ",password=" + password + "]");
    }
}
