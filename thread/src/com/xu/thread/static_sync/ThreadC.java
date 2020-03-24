package com.xu.thread.static_sync;

public class ThreadC implements Runnable {
    private StaticSyncmethodTest threadStaticTest;

    public ThreadC(StaticSyncmethodTest threadStaticTest) {
        this.threadStaticTest = threadStaticTest;
    }
    public void run() {
        threadStaticTest.methodC();
    }
}