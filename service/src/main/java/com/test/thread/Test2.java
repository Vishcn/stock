package com.test.thread;

/**
 * @author Vishcn
 * @since 2015年11月25日
 */
public class Test2 {

    public static void main(String[] args) throws Exception {

        System.out.println("start");
        ReadWriteLock lock = new ReadWriteLock();
        lock.wirteLock();
        System.out.println("end");
    }
}
