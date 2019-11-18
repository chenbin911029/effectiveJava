package main.proxy.aop.cglibAop;

/**
 * @Description: 该类作为AOP 模型中切面角色类， 实现切面接口
 * Created by chenbin on 2019\11\18 0018.
 */
public class CustomAspect implements IAspect {

    /**
     * 在切点方法之前执行，参数检查
     *
     * @return
     */
    @Override
    public void startTransaction() {
        System.out.println("cglib.start transaction");
    }

    /**
     * 切点方法之后执行
     */
    @Override
    public void endTransaction() {
        System.out.println("cglib.end transaction");
    }
}
