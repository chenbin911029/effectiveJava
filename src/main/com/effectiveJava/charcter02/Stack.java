package main.com.effectiveJava.charcter02;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Description:内存未被释放，会有内存泄漏的隐患
 * User: chenbin-pc
 * Date: 2018-05-10
 * Time: 9:37
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * 弹栈
     * 清空过期引用，如果它们以后又被错误地解除引用，
     * 程序就会抛出NullPointerException异常，
     * 而不是悄悄的错误运行下去，尽快检测出程序中的
     * 错误总是有益的。
     * @return
     */
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;//释放内存，若不释放会有内存泄漏隐患。
        return result;
    }

    /**
     * ensure space for at least one more element,roughly
     * doubling the capacity each time the array needs to grow.
     */
    @SuppressWarnings("Since15")
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements,2*size + 1);
        }
    }
}
