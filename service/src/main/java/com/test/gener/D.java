package com.test.gener;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Vishcn
 * @since 2015年11月23日
 */
public class D<T> {

    public void test(T t){
        System.out.println(t);
        System.out.println(t.getClass().getSimpleName());
    }

    public T get(T t){
        return null;
    }

    public void test1(T t){
        System.out.println(t);
        System.out.println(t.getClass().getSimpleName());
    }

    public static void main(String[] args) throws Exception{
        String a = "acb";
        System.out.println(a.hashCode());
//        System.out.println(b);
    }
    public void test() {
        Map m = new ConcurrentHashMap();
        m.put(null, "a");
    }
}
