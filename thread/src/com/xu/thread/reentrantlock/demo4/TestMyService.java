package com.xu.thread.reentrantlock.demo4;

import org.junit.jupiter.api.Test;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/21 15:40
 */
public class TestMyService {

    @Test
    public void test() throws InterruptedException {
        MyService service = new MyService();
        Thread threadA = new Thread(new MyServiceThreadA(service), "ThreadA");
        Thread threadB = new Thread(new MyServiceThreadB(service), "ThreadB");
        threadA.start();
        threadB.start();
        Thread.sleep(2000);

        service.signalAllB();
        Thread.sleep(1000);
        service.signalAllA();
    }
}
/**
 * 执行结果：
 * ThreadA 进入了await方法.
 * ThreadB 进入了await方法.
 * 启动唤醒程序
 * ThreadB被唤醒
 * ThreadB等待了: 1s
 * 启动唤醒程序
 * ThreadA被唤醒
 * ThreadA等待了: 3s
 */