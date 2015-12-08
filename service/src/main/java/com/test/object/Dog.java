package com.test.object;

/**
 * @author Vishcn
 * @since 2015年10月31日
 */
public class Dog extends Animal {

    public  String abc = "abc";

    private static String str = "Dog object";

    public Dog() {
        outStr();
    }

    public void outStr() {
        System.out.println("dog out");
        System.out.println(this.getClass().getName());
        System.out.println(str);
    }

}
