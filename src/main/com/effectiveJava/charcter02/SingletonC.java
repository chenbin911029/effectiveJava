package main.com.effectiveJava.charcter02;

import java.io.Serializable;

/**
 * Description:Singleton
 * 这种方法在功能上与公有域方法相近，但是它更加简洁，无偿提供了序列化机制，
 * 绝对防止多次实例化，即使是在面对复杂序列化或者反射攻击的时候。
 * 虽然这种方法还没有广泛采用，但是单元素的枚举类型已经成为实现Singleton的最佳方法。
 * User: chenbin-pc
 * Date: 2018-05-08
 * Time: 14:58
 */
public enum SingletonC implements Serializable {
    INSTANCE;
    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
