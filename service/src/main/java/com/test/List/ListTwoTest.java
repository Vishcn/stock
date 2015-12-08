package com.test.List;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author Vishcn
 * @since 2015年12月07日
 */
public class ListTwoTest {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        for (int i=0; i<10; i++) {
            list.add("" + i);
        }
        System.out.println(list);

        for (int i =0; i< list.size();i++) {
            if (i%2==0) {
                System.out.println(i);
                list.remove(i);
            }
        }
        System.out.println(list);

    }
}
