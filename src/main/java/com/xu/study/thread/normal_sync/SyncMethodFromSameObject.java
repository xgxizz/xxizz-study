package com.xu.study.thread.normal_sync;

/**
 * @Description  实例 调用synchronized 方法的对象是同一对象
 * @Author xgx
 * @Date 2019/11/20 11:13
 */
public class SyncMethodFromSameObject implements Runnable {
    private int status = 0;
    private synchronized void increase(){
        System.out.println(System.currentTimeMillis()+" increase begin");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()+" increase end");
    }
    private void decrease(){
        System.out.println(System.currentTimeMillis()+" decrease begin");
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()+" decrease end");
    }
    @Override
    public synchronized void run() {
        if (status == 0){
            status = 1;
            increase();
        }else {
            status = 0;
            decrease();
        }
    }

    public static void main(String[] args) {
        SyncMethodFromSameObject myThread = new SyncMethodFromSameObject();

        //锁是当前对象 myThread
        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     *
     */
}
