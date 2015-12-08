package com.test.thread;

/**
 * @author Vishcn
 * @since 2015年11月25日
 */
public class ReadWriteLock {

    private static int writers = 0;

    private static int readers = 0;

    private static int writeRequests = 0;

    public synchronized void readLock() throws InterruptedException {
        while(writers >0 || writeRequests > 0) {
            wait();
        }
        readers ++ ;
    }

    public synchronized void wirteLock() throws InterruptedException {
        writers++;
        wait();
    }

}
