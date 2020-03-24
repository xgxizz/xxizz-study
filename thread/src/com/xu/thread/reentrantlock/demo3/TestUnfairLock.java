package com.xu.thread.reentrantlock.demo3;

import org.junit.jupiter.api.Test;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/21 15:09
 */
public class TestUnfairLock {
    @Test
    public void testFairLock(){
        final Service service = new Service(false);  //改为false就为非公平锁了
        Runnable runnable = new Runnable() {
            public void run() {
                service.serviceMethod();
            }
        };
        Thread []threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(runnable , "Thread-"+i);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}
