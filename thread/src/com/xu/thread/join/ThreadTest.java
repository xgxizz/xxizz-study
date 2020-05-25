package com.xu.thread.join;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Service thread01 = new Service("thread01");
        Service thread02 = new Service("thread02");
        thread01.start();
        /*程序在main线程中调用t1线程的join方法，则main线程放弃cpu控制权，并返回t1线程继续执行直到线程t1执行完毕
         所以结果是t1线程执行完后，才到主线程执行，相当于在main线程中同步t1线程，t1执行完了，main线程才有执行的机会*/
        thread01.join();//main函数从上至下依次执行，执行到这一句main线程放弃cpu控制，此时thread02还没有开始执行，即不会start

        thread02.start();


    }
}
