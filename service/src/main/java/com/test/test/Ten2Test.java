package com.test.test;

/**
 * @author Vishcn
 * @since 2015年10月20日
 */
public class Ten2Test {


    public Integer sixTy2Ten(String str) {
        return Integer.parseInt(str,16);
    }

    public Integer strTy2Ten(String str, int i) {
        return Integer.parseInt(str,i);
    }

    public void str2SixTy(int i) {
        System.out.println("to:" + Integer.toHexString(i));
        System.out.println("to:" + Integer.toBinaryString(i));
        System.out.println("to:" + Integer.toOctalString(i));
    }
}
