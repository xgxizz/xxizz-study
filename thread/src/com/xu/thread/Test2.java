package com.xu.thread;


public class Test2 {

    static int b;

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();
        System.out.println("执行开始时间：" + startTime);
        Thread[] thread_bs = new Thread[200000];
        for (int i = 0; i < 200000; i++) {
            thread_bs[i] = new Thread(() -> increase());
        }
        for (int i = 0; i < 200000; i++) {
            thread_bs[i].start();
            //thread_bs[i].join();
        }
        System.out.println("预期结果：b=" + 200000);
        System.out.println("多线程情况下:b=" + b);

        long endTime = System.currentTimeMillis();
        System.out.println("执行结束时间：" + endTime);
        System.out.println("总耗时："+ (endTime - startTime));
    }

    public static synchronized void increase(){
        b ++;
    }
}
