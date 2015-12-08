package com.test.gener;


import com.google.common.collect.Lists;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Vishcn
 * @since 2015年11月23日
 */
public class Test {


    public <T extends A>  List<T> test(T t) {
        List<T> list = Lists.newArrayList();
        list.add(t);
        return list;
    }
    public static void main(String[] args) throws Exception {


        List<Integer> list = Lists.newArrayList();
        list.add(34);
//        List<Object extend A> list1 = Lists.newArrayList();

//        List a = new ArrayList();
        Class<?> clz1 = list.getClass();
        Method m = clz1.getDeclaredMethod("add", Object.class);
        B b = new B();
        b.setAbc("dec");
        m.invoke(list, b);

        Test test = new Test();
        A a = new A();
        C c = new C();
        c.setImC("C");
        List<A> l = test.test(a);
        List<B> l1 = test.test(b);
        m.invoke(l, a);
        m.invoke(l, b);
        m.invoke(l, c);
        D<A> d = new D<A>();
        d.test(a);
        d.test(b);
//        d.test(c);
        Class<?> dClass = d.getClass();
        Method mt = dClass.getDeclaredMethod("test" , Object.class);
        mt.invoke(d, a);
        mt.invoke(d, b);
//        mt.invoke(d, c);
        System.out.println("=======");
        System.out.println(list.size());
        System.out.println(list.get(0));
        Iterator i = list.iterator();
        while(i.hasNext()){
            Object o = i.next();
            if (o instanceof B) {
                System.out.println(((B)o).getAbc());
            }
            if (o instanceof Integer) {
                System.out.println(o);
            }
        }

    }
}
