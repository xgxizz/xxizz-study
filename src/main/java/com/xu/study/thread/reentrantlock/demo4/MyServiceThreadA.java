package com.xu.study.thread.reentrantlock.demo4;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/21 15:37
 */
public class MyServiceThreadA implements Runnable {
    private MyService service ;

    public MyServiceThreadA(MyService service){
        this.service = service;
    }
    @Override
    public void run() {
        service.awaitA();
    }
}
