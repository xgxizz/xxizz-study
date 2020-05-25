package com.xu.thread.volatail;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by andrew.huang on 2018/1/4.
 * 来源：https://www.jianshu.com/p/cd4744d799e4
 */
public class VolatileMain {

    static volatile Integer x = 0;


    //反复执行main方法，会出现最终结果为1998，1999...的情况 并不是我们期待的2000，由此可以证明volatile是不具有原子性的
   /**
    * 而这还只是在两个线程并发的执行情况下，
    * 在生产环境里面大量线程并发情况下，volatile造成的值缺失问题会更加严重，
    * 所以如果单独使用volatile去作为并发策略，需要在比使用锁(synchronized和lock)要考虑更多的因素和情况。
    */
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new TestThread1());
        service.execute(new TestThread2());
        service.shutdown();
    }

    static class TestThread1 implements Runnable{

        @Override
        public void run() {
            for(int i = 0;i < 1000;i++){
                x++;
                System.out.println("thread1 is " + "time is " + i + "result is " + x);
            }
        }
    }

    static class TestThread2 implements Runnable{

        @Override
        public void run() {
            for(int i = 0;i < 1000;i++){
                x++;
                System.out.println("thread2 is " + "time is " + i + "result is " + x);
            }
        }
    }

}

