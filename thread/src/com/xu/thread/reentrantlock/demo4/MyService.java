package com.xu.thread.reentrantlock.demo4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/21 15:25
 */
public class MyService {

    private ReentrantLock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    public void awaitA(){
        try {
            lock.lock();

            System.out.println(Thread.currentThread().getName() + " 进入了await方法.");
            long timeBefore = System.currentTimeMillis();
            //condition 在lock 和unlock 之间执行
            conditionA.await();
            long timeAfter = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName()+"被唤醒");
            System.out.println(Thread.currentThread().getName() + "等待了: " + (timeAfter - timeBefore)/1000+"s");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {


            lock.unlock();
        }
    }

    public void awaitB(){
        try {
            lock.lock();

            System.out.println(Thread.currentThread().getName() + " 进入了await方法.");
            long timeBefore = System.currentTimeMillis();
            conditionB.await();
            long timeAfter = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName()+"被唤醒");
            System.out.println(Thread.currentThread().getName() + "等待了: " + (timeAfter - timeBefore)/1000+"s");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalAllA(){
        lock.lock();
        System.out.println("启动唤醒程序");
        // 唤醒所有注册conditionA的线程
        conditionA.signalAll();
        lock.unlock();
    }

    public void signalAllB(){
        lock.lock();
        System.out.println("启动唤醒程序");
        // 唤醒所有注册conditionB的线程
        conditionB.signalAll();
        lock.unlock();
    }
}
