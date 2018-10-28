package main.com.effectiveJava.charcter05;

import java.util.*;

/**
 * Description:
 * User: chenbin-pc
 * Date: 2018-05-10
 * Time: 8:59
 */

public class Generic<T> {
//    public static <E> Generic<E> union(Generic s1, Generic s2) {
//        Generic<E> result = new HashSet<E>();
//        result.addAll(s2);
//        return result;
//    }

    public void test() {
        Map<String,List<String>> anagrams = newHashMap();
        Map<String,List<String>> anagrams2 = new HashMap<String, List<String>>();
    }

    //generic static factory method
    public static <K,V> HashMap<K,V> newHashMap() {
        return new HashMap<K, V>();
    }

    private static UnaryFunction<Object> IDENTITY_FUNCTION =
                new UnaryFunction<Object>() {
                    public Object apply(Object arg){return arg;}
                };
    //泛型单例
    public static <T> UnaryFunction<T> identityFunction() {
        return (UnaryFunction<T>) IDENTITY_FUNCTION;
    }

    public static void main(String[] args) {
        String[] strings = {"jute","hemp","nylon"};
        UnaryFunction<String> sameString = identityFunction();
        for (String s : strings)
            System.out.println(sameString.apply(s));

        Number[] numbers = {1,2,0,3L};
        UnaryFunction<Number> sameNumber = identityFunction();
        for (Number n : numbers)
            System.out.println(sameNumber.apply(n));
    }

    public static <T extends Comparable<T>> T max(List<T> list) {
        Iterator<T> i = list.iterator();
        T result = i.next();
        while (i.hasNext()){
            T t = i.next();
            if (t.compareTo(result) > 0)
                result = t;
        }
        return result;
    }

//    public static <E> Set<E> union(Set<? extends E>,Set<? extends E>) {
//        return null;
//    }
}
