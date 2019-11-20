package com.xu.study.thread.normal_sync;
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
            thread1.join();
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
 */