package main.proxy.aop.cglibAop;

/**
 * @Description: 定义切面接口，切面接口定义了两个切面方法，
 * 分别在切点接口方法执行前和执行后执行
 * Created by chenbin on 2019\11\18 0018.
 */
public interface IAspect {
    /**
     * 在切点方法之前执行，参数检查
     * @return
     */
    void startTransaction();
    /**
     * 切点方法之后执行
     */
    void endTransaction();
}
