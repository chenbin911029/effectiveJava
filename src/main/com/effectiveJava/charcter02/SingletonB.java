package main.com.effectiveJava.charcter02;

import java.io.Serializable;

/**
 * Description:Singleton
 * User: chenbin-pc
 * Date: 2018-05-08
 * Time: 14:58
 */
public class SingletonB implements Serializable {
    private static final SingletonB INSTANCE = new SingletonB();
    private SingletonB(){}
    public static SingletonB getInstance(){
        return INSTANCE;
    }

    // 不添加该方法则会出现 反序列化时出现多个实例的问题
    public Object readResolve() {
        return INSTANCE;
    }
}
