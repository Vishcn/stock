package com.test.Integer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Vishcn
 * @since 2015年12月08日
 */
public class WanTest {

    public static  int race = 0;

    public static AtomicInteger atomRace = new AtomicInteger();

    public static void increase() {
        race++;
        atomRace.incrementAndGet();
    }

    private static final int THREADS_COUNT = 20;


    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        long l1 = System.currentTimeMillis();
        System.out.println(race);
        System.out.println(atomRace);
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0; i < 10000; i++) {
                        increase();
                    }
                }
            }) ;
            threads[i].start();
        }
        while(Thread.activeCount() > 2) {
            Thread.yield();
        }
        long l2 = System.currentTimeMillis();
        System.out.println("count=" + (l2-l1));
        System.out.println(race);
        System.out.println(atomRace);
    }
}
