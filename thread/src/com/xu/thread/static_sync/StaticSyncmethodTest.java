package com.xu.thread.static_sync;
/*验证同类的static 方法之间， 锁是同一个锁。*/
public class StaticSyncmethodTest {
    public synchronized static void staticMethodA() {
        System.out.println(Thread.currentThread().getName() + " staticMethodA in "
            + System.currentTimeMillis());
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " staticMethodA out " 
            + System.currentTimeMillis());
    }

    public synchronized static void staticMethodB() {
        System.out.println(Thread.currentThread().getName() + " staticMethodB in " 
            + System.currentTimeMillis());
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " staticMethodB out " 
            + System.currentTimeMillis());
    }
    public synchronized void methodC() {
        System.out.println(Thread.currentThread().getName() + " methodC in "
                + System.currentTimeMillis());
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " methodC out "
                + System.currentTimeMillis());
    }


    public static void main(String[] args) {
        StaticSyncmethodTest threadStaticTest = new StaticSyncmethodTest();
        Thread ta = new Thread(new ThreadA(threadStaticTest));
        Thread tb = new Thread(new ThreadB(threadStaticTest));
        Thread tc = new Thread(new ThreadC(threadStaticTest));
        ta.setName("ThreadA");
        tb.setName("ThreadB");
        tc.setName("ThreadC");
        ta.start();
        tb.start();
        tc.start();

        try {
            ta.join();
            tb.join();
            tc.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

/**
 * 如果 synchronized 作用在静态方法上， 锁的是当前的 Class 进行加锁。因为静态成员不属于具体的某一个对象，
 * 因此显然继续使用 this 作为锁是不可行的。
 *
 * 结果上看，没什么不同。
 * 但其本质上， 锁的对象还是不一样的， synchronized 关键字加到静态方法上， 锁的是 Class 类， 而加到非静态方法上， 锁的是 this对象。
 *
 *
 * 可以看到， 名为 ThreadC 的线程“乱入”， 而线程 ThreadA 和 ThreadB 还是一个结束后一个在进入。
 * 证明 ThreadA 和 ThreadB 持有的是同一个锁。
 */