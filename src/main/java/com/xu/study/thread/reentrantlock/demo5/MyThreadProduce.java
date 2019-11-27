package com.xu.study.thread.reentrantlock.demo5;

/**
 * 生产者线程
 *
 */
public class MyThreadProduce implements Runnable{

    private PCService service;

    public MyThreadProduce(PCService service) {
        this.service = service;
    }

    @Override
    public void run() {
        for (;;) {
            service.produce();
        }
    }

}