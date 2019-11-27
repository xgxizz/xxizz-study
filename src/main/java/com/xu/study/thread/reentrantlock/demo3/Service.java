package com.xu.study.thread.reentrantlock.demo3;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/21 14:36
 */
public class Service {
    @Getter
    @Setter
    private ReentrantLock lock;

    public Service(boolean isFair){
        lock = new ReentrantLock();
    }
    public void serviceMethod(){
        System.out.println(Thread.currentThread().getName() +  " 开始运行，马上获取锁...... " );
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " get lock.");
        }finally {
            lock.unlock();
        }
    }
}
