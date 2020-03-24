package com.xu.thread.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/20 17:15
 */
public class ReentrantLock2 {
    private Lock lock = new ReentrantLock();
    private void method1(){
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                //这里如果改为1000（1s）下面的method2将在5s内获取不到锁
                TimeUnit.MICROSECONDS.sleep(500);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    private void method2(){
        boolean locked = false;
        try {
            locked = lock.tryLock(5,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (locked){
                System.out.println("m2------------");
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) {
        ReentrantLock2 rl = new ReentrantLock2();
        new Thread(rl::method1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        new Thread(rl::method2).start();
    }
}
