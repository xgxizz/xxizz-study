package com.xu.thread.normal_sync;

/**
 * @Description  实例 调用synchronized 方法的对象是同一对象
 * @Author xgx
 * @Date 2019/11/20 11:13
 */
public class SyncMethodFromSameObject implements Runnable {
    private int status = 0;
    private static int count = 0;
    private synchronized void increase(){
        count ++;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20000; i++) {
            increase();
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
            System.out.println(count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 注意与SyncMethodFromDiffObject对比
     */
}
