package com.xu.study.thread.reentrantlock.demo0;

import org.junit.jupiter.api.Test;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/21 14:14
 */
public class TestLock {

    @Test
    public void testLock(){
        //新建线程对象
        Runnable runnable = new ReentrantLockThread();
        Thread threadA = new Thread(runnable, "threadA");
        Thread threadB = new Thread(runnable, "threadB");
        threadA.start();
        threadB.start();
    }
}
/**
 *
 *查看控制台输出为：
 * threadA输出了:0
 * threadA输出了:1
 * threadA输出了:2
 * threadB输出了:0
 * threadB输出了:1
 * threadB输出了:2
 * 有顺序的打印出了0，1，2。这就是锁的作用，它是互斥的，当一个线程持有锁的时候，其他线程只能等待，待该线程执行结束，再通过竞争得到锁。
 */
