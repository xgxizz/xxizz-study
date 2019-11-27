package com.xu.study.thread.reentrantlock.demo6;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/21 16:47
 */
public class ConditionThreadA implements Runnable {

    private ConditionService conditionService;

    public ConditionThreadA(ConditionService conditionService){
        this.conditionService = conditionService;
    }
    @Override
    public void run() {
        while (true) {
            conditionService.methodA();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
