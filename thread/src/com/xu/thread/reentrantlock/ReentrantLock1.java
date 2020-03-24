package com.xu.thread.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 参考自csdn:https://blog.csdn.net/it_qingfengzhuimeng/article/details/83871024
 * @Author xgx
 * @Date 2019/11/20 16:59
 * 使用ReentrantLock可以代替Synchronized
 *  * 需注意：必须手动释放锁（重要！！！！）
 *  * 使用synchronized如果遇到异常，jvm会自动释放锁
 *  * 当时lock会手动释放锁，因此经常在finally中进行锁的释放
 */
public class ReentrantLock1 {
    private Lock lock = new ReentrantLock();
    private void method1(){
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    private void method2(){
        lock.lock();
        System.out.println("m2-------------");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLock1 rl = new ReentrantLock1();
        new Thread(rl::method1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        new Thread(rl::method2).start();
    }
}
