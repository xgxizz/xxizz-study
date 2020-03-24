package com.xu.thread.reentrantlock.demo5;

public class MyThreadConsume implements Runnable{

    private PCService service;

    public MyThreadConsume(PCService service) {
        this.service = service;
    }

    @Override
    public void run() {
        for (;;) {
            service.consume();
        }
    }    
}