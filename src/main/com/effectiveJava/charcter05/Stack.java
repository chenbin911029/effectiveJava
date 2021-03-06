package main.com.effectiveJava.charcter05;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Description:
 * User: chenbin-pc
 * Date: 2018-05-10
 * Time: 8:59
 */

public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    @SuppressWarnings("Since15")
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements,2 * size + 1);
        }
    }
}
