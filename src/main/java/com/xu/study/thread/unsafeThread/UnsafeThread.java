package com.xu.study.thread.unsafeThread;

/**
 * @Description 问题引入
 * @Author xgx
 * @Date 2019/11/20 10:31
 */
public class UnsafeThread implements Runnable{

    private static int count = 0;
    private void increase(){
        count ++ ;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2000000; i++) {
            this.increase();
        }

    }

    public static void main(String[] args) {
        UnsafeThread myThread = new UnsafeThread();
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
 * 1.存在问题：执行后， 两个线程， 每个线程对 count 进行了 2000000 次自增， 预期的结果应该是 4000000,
 * 然而， 执行后发现结果基本上都不是对的， 每次不一样, 但都比 4000000 小。
 * 2.线程安全性的定义：当多个线程访问某一个类时， 这个类始终能表示出正确的行为， 那么就称这个类是线程安全的。
 * 3.线程安全问题产生的原因归结如下：
 *      3.1.共享数据：只有共享的数据才会产生带来安全性问题。 如果是方法内部声明的变量， 其是在虚拟机栈中， 为每个线程独享， 不存在安全性问题。
 *      3.2.多个线程对共享数据进行同时操作。多线程对同一共享数据进行同时性的操作，此时共享数据就会影响到彼此。
 * 4.问题分析：i++ 的步骤， 应该是：
 * 读->改->写
 * 但是， 如果在一个线程读的时候， 还没写回去， 另一个线程也读了，那么就是有一次操作相当于没有效， 导致最后的结果就会比预期的少了。
 * 5.解决对策：
 *      5.1 消除共享数据： 想法很好， 但有些情况下想要完全的消除是不可能的， 我们只可能尽可能的减少共享数据。
 *      5.2 限定同一时刻， 只有一个线程能对共享数据进行操作， 其他线程需要等到该线程处理完之后再进行操作。
 * 6. 互斥锁
 * 互斥锁的特点
 * 线程在进入同步代码块之前会自动获取锁，并且在退出同步代码块时会自动释放锁。
 * 在同一时刻， 只有一个线程能持有这个锁。当线程 A 尝试获取一个由线程 B 持有的锁时， 线程 A 必须等待或阻塞， 直到线程 B 释放了这个锁。 如果 B 不释放这个锁， 则 A 就需要一直等待。
 * 可重入性： 指的是同一线程 外层函数获得锁之后 ，内层递归函数仍然有获取该锁的代码，但不受影响。
 * 7.内置锁
 * Java的synchronized（Java内置的互斥锁）
 * 由 synchronized 修饰的代码块以原子方式（一组语句组成一个不可分割的单元）执行。
 * synchronized 的使用有如下三种方式：
 *      7.1 普通同步方法，锁是当前实例对象(this);
 *      7.2 静态同步方法，锁是当前类的 Class 对象;
 *      7.3 同步代码块，锁是括号里面的对象。
 */
