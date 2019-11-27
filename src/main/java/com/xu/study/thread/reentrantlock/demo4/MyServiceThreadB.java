package com.xu.study.thread.reentrantlock.demo4;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/21 15:38
 */
public class MyServiceThreadB implements Runnable {

    private MyService service ;

    public MyServiceThreadB(MyService service){
        this.service = service;
    }
    @Override
    public void run() {
        service.awaitB();
    }
}
