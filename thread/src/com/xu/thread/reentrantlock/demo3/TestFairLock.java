package com.xu.thread.reentrantlock.demo3;


import org.junit.Test;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/21 14:40
 */
public class TestFairLock {

    @Test
    public void testFairLock() throws InterruptedException {
        final Service service = new Service(true);  //改为false就为非公平锁了
        Runnable runnable = new Runnable() {
            public void run() {
                service.serviceMethod();
            }
        };
        Thread []threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(runnable , "Thread-"+i);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
            //threads[i].join();
        }
    }
}
/**
 * 运行结果按照请求锁的顺序输出。（由于打印与 lock()方法执行有先后，获取锁的顺序可能仍有变化，所以输出结果并不能完全表征公平锁，有误差）
 * 打印的结果是按照线程加锁的顺序输出的，即线程运行了，则会先获得锁。
 */
