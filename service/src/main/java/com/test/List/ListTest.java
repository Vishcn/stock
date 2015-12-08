package com.test.List;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vishcn
 * @since 2015年11月30日
 */
public class ListTest {

    public static void main(String[] args) {
        List list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        List str = list.subList(0, 2);
        str.get(1);
        System.out.println("abce");
        System.out.println(str);
    }
}
