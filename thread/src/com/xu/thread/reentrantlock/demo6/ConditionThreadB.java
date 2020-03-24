package com.xu.thread.reentrantlock.demo6;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/21 16:49
 */
public class ConditionThreadB implements Runnable {
    private ConditionService conditionService;

    public ConditionThreadB(ConditionService conditionService){
        this.conditionService = conditionService;
    }
    @Override
    public void run() {
        while (true) {
            conditionService.methodB();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
