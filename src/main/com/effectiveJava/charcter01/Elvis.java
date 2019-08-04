package main.com.effectiveJava.charcter01;

/**
 * Created by chenbin on 2019\8\4 0004.
 */
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();
    //用私有构造器强化singleton属性
    private Elvis(){}
    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding(){}
}
