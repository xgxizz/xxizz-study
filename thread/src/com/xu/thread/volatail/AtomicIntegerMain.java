package com.xu.thread.volatail;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerMain {

    static AtomicInteger x = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new TestThread1());
        executorService.execute(new TestThread2());
        executorService.shutdown();
    }

    static class TestThread1 implements Runnable{

        @Override
        public void run() {
            for(int i = 0;i < 1000;i++){
                x.incrementAndGet();
                System.out.println("thread1 is " + "time is " + i + "result is " + x);
            }
        }
    }

    static class TestThread2 implements Runnable{

        @Override
        public void run() {
            for(int i = 0;i < 1000;i++){
                x.incrementAndGet();
                System.out.println("thread2 is " + "time is " + i + "result is " + x);
            }
        }
    }
}
