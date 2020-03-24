package com.xu.thread.reentrantlock.demo6;

import org.junit.jupiter.api.Test;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/21 16:52
 */
public class Application {

    @Test
    public void test(){
        ConditionService service = new ConditionService();
        Runnable A = new ConditionThreadA(service);
        Runnable B = new ConditionThreadB(service);
        Runnable C = new ConditionThreadC(service);

        new Thread(A, "A").start();
        new Thread(B, "B").start();
        new Thread(C, "C").start();
    }
}
