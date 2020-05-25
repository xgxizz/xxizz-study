package com.xu.thread;


public class Test {

    volatile static int a;

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();
        System.out.println("执行开始时间：" + startTime);
        Thread[] threads = new Thread[200000];
        for (int i = 0; i < 200000; i++) {
            threads[i] = new Thread(() -> a++);
        }
        for (int i = 0; i < 200000; i++) {
            threads[i].start();
            threads[i].join();
        }
        System.out.println("预期结果：a=" + 200000);
        System.out.println("多线程情况下:a=" + a);
        long endTime = System.currentTimeMillis();
        System.out.println("执行结束时间：" + endTime);
        System.out.println("总耗时："+ (endTime - startTime));
        
    }

}
