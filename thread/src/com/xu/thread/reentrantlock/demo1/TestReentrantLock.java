package com.xu.thread.reentrantlock.demo1;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/21 14:24
 */
public class TestReentrantLock {

    @Setter
    @Getter
    private ReentrantLock lock;

    public void testReentrant(){
        lock.lock();
        Calendar now = Calendar.getInstance();
        System.out.println(now.getTime() + Thread.currentThread().getName() + " get lock.");
    }

    public TestReentrantLock(){
        lock = new ReentrantLock();
    }

    public static void main(String[] args) {
        TestReentrantLock testReentrantLock = new TestReentrantLock();
        try {
            // 测试可重入，方法testReentrant() 在同一线程中,可重复获取锁,执行获取锁后，显示信息的功能
            testReentrantLock.testReentrant();
            // 能执行到这里而不阻塞，表示锁可重入
            testReentrantLock.testReentrant();
            testReentrantLock.testReentrant();
        }finally {
            // 释放重入测试的锁，要按重入的数量解锁，否则其他线程无法获取该锁。
            testReentrantLock.getLock().unlock();
            testReentrantLock.getLock().unlock();
            testReentrantLock.getLock().unlock();
        }
    }

}

/**
 * 输出结果：
 * Thu Nov 21 14:33:22 CST 2019main get lock.
 * Thu Nov 21 14:33:22 CST 2019main get lock.
 * Thu Nov 21 14:33:22 CST 2019main get lock.
 */
