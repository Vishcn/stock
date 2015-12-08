package com.test.object;

/**
 * @author Vishcn
 * @since 2015年10月31日
 */
public class Animal {

    private static String str = "animal object";
    public Animal() {
        outStr1();
    }

    public void outStr1() {
        System.out.println("Animal out");
        System.out.println(this.getClass().getName());
        System.out.println(str);
    }
}
