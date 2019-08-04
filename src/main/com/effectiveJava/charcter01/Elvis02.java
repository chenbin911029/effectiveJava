package main.com.effectiveJava.charcter01;

/**
 * Created by chenbin on 2019\8\4 0004.
 */
public enum Elvis02 {
    //用枚举类强化singleton属性
    //单元素枚举类已经成为实现singleton的最佳方法
    INSTANCE;
    public void leaveTheBuilding() {}
}
