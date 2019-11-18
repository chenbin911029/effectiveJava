package main.proxy.cglibproxy;

/**
 * @description: Cglib代理模式中被代理的 委托类
 * Created by chenbin on 2019\11\18 0018.
 */
public class Football {
    public String play() {
        System.out.println("I play football last 4 years.");
        return "football";
    }
}
