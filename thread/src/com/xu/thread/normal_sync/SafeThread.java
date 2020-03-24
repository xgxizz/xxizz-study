package com.xu.thread.normal_sync;
/*
 * @Description  普通同步方法
 * @Author xgx
 * @Date 2019/11/20 11:01
 * @Param
 * @return
 */
public class SafeThread implements Runnable{

    private static int count = 0;

    private synchronized void increase(){
        count ++ ;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2000000; i++) {
            this.increase();
        }

    }

    public static void main(String[] args) {
        SafeThread myThread = new SafeThread();
        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);
        thread1.start();
        thread2.start();
        try {
            thread1.join();//join方法表示主线程等待子线程执行完成之后再执行
            thread2.join();
            System.out.println("count:" + count);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 结果正常显示为4000000
 *
 * 普通同步方法，锁是当前实例对象(this);
 *
 * join():在很多情况下，主线程生成并起动了子线程，如果子线程里要进行大量的耗时的运算，主线程往往将于子线程之前结束，
 * 但是如果主线程处理完其他的事务后，需要用到子线程的处理结果，也就是 主线程需要等待子线程执行完成之后再结束，这个时候就要用到join()方法了。
 */