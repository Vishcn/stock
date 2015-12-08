package com.test.map;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author Vishcn
 * @since 2015年12月07日
 */
public class HashMaps {

    public static void main(String[] args) throws Exception{
        final HashMap<String, String> map = new HashMap<String, String>(2);
        final Integer j = 0;
        Thread t = new Thread(new Runnable() {

            @Override

            public void run() {

                for (int i = 0; i < 10000; i++) {

                    new Thread(new Runnable() {

                        @Override

                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                            System.out.println(System.currentTimeMillis());
                        }

                    }, "ftf" + i).start();

                }

            }
        }, "ftf");

        t.start();

        t.join();
    }
}
