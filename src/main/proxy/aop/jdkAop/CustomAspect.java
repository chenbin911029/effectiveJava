package main.proxy.aop.jdkAop;

import java.util.Objects;

/**
 * @Description: 该类作为AOP 模型中切面角色类， 实现切面接口
 * Created by chenbin on 2019\11\18 0018.
 */
public class CustomAspect implements IAspect {
    /**
     * 在切点方法之前执行，参数检查
     *
     * @param objects 可变参数列表
     * @return
     */
    @Override
    public boolean startTransaction(Object... objects) {
        assert Objects.nonNull(objects);
        boolean result = true;
        for (Object temp : objects) {
            if (Objects.isNull(temp)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * 切点方法之后执行
     */
    @Override
    public void endTransaction() {
        System.out.println("after method.end transaction.");
    }
}
