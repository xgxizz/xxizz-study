package com.xu.thread.reentrantlock.demo6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/21 16:37
 */
public class ConditionService {

    private static int nextThread = 1;
    private ReentrantLock lock =  new ReentrantLock();
    // 有三个线程，所以注册三个Condition
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    public void methodA(){
        try {
            lock.lock();
            while (nextThread != 1) {
                System.out.println(Thread.currentThread().getName() + "挂起...");
                conditionA.await();
            }
            System.out.println(Thread.currentThread().getName() + "工作");
            nextThread = 2;
            conditionB.signalAll();
            System.out.println("唤醒B");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void methodB(){
        try {
            lock.lock();
            while (nextThread != 2) {
                System.out.println(Thread.currentThread().getName() + "挂起...");
                conditionB.await();
            }
            System.out.println(Thread.currentThread().getName() + "工作");
            nextThread = 3;
            conditionC.signalAll();
            System.out.println("唤醒C");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void methodC(){
        try {
            lock.lock();
            while (nextThread != 3) {
                System.out.println(Thread.currentThread().getName() + "挂起...");
                conditionB.await();
            }
            System.out.println(Thread.currentThread().getName() + "工作");
            nextThread = 1;
            conditionA.signalAll();
            System.out.println("唤醒A");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
