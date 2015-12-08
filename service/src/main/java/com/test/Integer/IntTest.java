package com.test.Integer;

/**
 * @author Vishcn
 * @since 2015年12月07日
 */
public class IntTest {

    public static void main(String[] args) {
        int a = 10;
        int b = Integer.valueOf("10");
        System.out.println(a==b);
        Integer i = 10;
        Integer j = Integer.valueOf("10");
        System.out.println(i==j);

    }
}
