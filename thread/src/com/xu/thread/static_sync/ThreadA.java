package com.xu.thread.static_sync;

public class ThreadA implements Runnable {
    private StaticSyncmethodTest threadStaticTest;

    public ThreadA(StaticSyncmethodTest threadStaticTest) {
        this.threadStaticTest = threadStaticTest;
    }
    public void run() {
        threadStaticTest.staticMethodA();
    }
}
