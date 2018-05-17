package main.com.effectiveJava.charcter02;

import org.junit.Test;

import java.util.Date;

/**
 * Description:
 * User: chenbin-pc
 * Date: 2018-05-10
 * Time: 8:59
 */
public class AutoBoxing {
    /**
     * 程序构造了大约2^31个多余的Long实例
     */
    @Test
    public void testBoxed() {
        long timeStamp = System.currentTimeMillis();
        Long sum = 0L;
        for (long i = 0;i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long timeStamp2 = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println(timeStamp2-timeStamp);
    }

    /**
     * 3.要优先使用基本类型，而不是装箱类型，要当心无意识的自动装箱
     */
    @Test
    public void noBoxed() {
        long timeStamp = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0;i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long timeStamp2 = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println(timeStamp2-timeStamp);
    }
}
