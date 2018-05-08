package com.effectiveJava.core.charcter02;

/**
 * Description:Singleton
 * User: chenbin-pc
 * Date: 2018-05-08
 * Time: 14:58
 */
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();
    private Elvis(){}
    public static Elvis getInstance(){
        return INSTANCE;
    }
}
