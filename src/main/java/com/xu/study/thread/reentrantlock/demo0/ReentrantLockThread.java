package com.xu.study.thread.reentrantlock.demo0;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/21 14:10
 */
public class ReentrantLockThread implements Runnable {
    //创建一个ReentrantLock对象
    ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        lock.lock();//加锁
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() +"输出了:" + i);
            }
        }finally {
            lock.unlock();//解锁
        }
    }
}
