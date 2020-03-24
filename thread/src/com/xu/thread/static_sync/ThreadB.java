package com.xu.thread.static_sync;

public class ThreadB implements Runnable {
    private StaticSyncmethodTest threadStaticTest;

    public ThreadB(StaticSyncmethodTest threadStaticTest) {
        this.threadStaticTest = threadStaticTest;
    }
    public void run() {
        threadStaticTest.staticMethodB();
    }
}
