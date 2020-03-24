package com.xu.thread.reentrantlock.demo5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/21 16:07
 */
public class PCService {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean flag = false; //互斥信号量
    private int number = 0; //商品总数

    //生产者
    public void produce() {

        try {
            lock.lock();
            while (flag == true) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "-----生产者开始生产商品-----");
            number ++;
            System.out.println("number: " + number);
            System.out.println();
            flag = true;
            // 提醒消费者消费
            condition.signalAll();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void consume(){
        lock.lock();
        try {
            while(flag == false){
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "-----消费者开始消费-----");
            number--;
            System.out.println("number: " + number);
            System.out.println();
            flag = false;
            // 提醒生产者生产
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
