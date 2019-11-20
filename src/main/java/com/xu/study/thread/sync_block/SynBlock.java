package com.xu.study.thread.sync_block;

public class SynBlock {

    private Lock lockA = new Lock();

    private Lock lockB = new Lock();

    private static int countA = 0;

    private static int countB = 0;

    public void methodA() {
        synchronized (lockA) {
            try {
                System.out.println(Thread.currentThread().getName() + " methodA begin "
                        + System.currentTimeMillis());
                for (int i = 0; i < 2000000; i++) {
                    countA++;
                }
                Thread.sleep(1000L);
                System.out.println(Thread.currentThread().getName() + " methodA end "
                        + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void methodB() {
        synchronized (lockB) {
            try {
                System.out.println(Thread.currentThread().getName() + " methodA begin "
                        + System.currentTimeMillis());
                for (int i = 0; i < 1000000; i++) {
                    countB++;
                }
                Thread.sleep(2000L);
                System.out.println(Thread.currentThread().getName() + " methodA end "
                        + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Lock {

    }

    public static void main(String[] args) {
        SynBlock synBlock = new SynBlock();
        Thread threadA = new Thread(new SynBlockThreadA(synBlock));
        Thread threadB = new Thread(new SynBlockThreadB(synBlock));

        threadA.setName("ThreadA");
        threadB.setName("ThreadB");
        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
            System.out.println("countA=" + countA);
            System.out.println("countB=" + countB);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
