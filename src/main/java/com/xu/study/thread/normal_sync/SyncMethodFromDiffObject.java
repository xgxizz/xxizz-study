package com.xu.study.thread.normal_sync;

/**
 * @Description  实例 验证不同的对象普通方法的锁不一样
 * 如果对象不一样， 则锁不一样， 起不到作用。
 * @Author xgx
 * @Date 2019/11/20 11:13
 */
public class SyncMethodFromDiffObject implements Runnable {
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
        SyncMethodFromDiffObject myThread1 = new SyncMethodFromDiffObject();
        SyncMethodFromDiffObject myThread2 = new SyncMethodFromDiffObject();
        //锁是当前对象 myThread
        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);//此处如果使用myThread1则最终结果为4000000
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
     * 输出结果也会是比 4000000 小的数字， 因为 count 是 static 修饰的， 是一个全局变量， 哪怕是两个不同的对象操作的也是同一个变量。
     * 而由于 myThread1 和 myThread2 是两个不同的对象， 因此 synchronized 锁的对象就不一样， 锁不一样就起不到互斥的效果。
     *
     */
}
