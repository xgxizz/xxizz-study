package com.xu.thread.reentrantlock.demo6;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/21 16:50
 */
public class ConditionThreadC implements Runnable {

    private ConditionService conditionService;

    public ConditionThreadC(ConditionService conditionService){
        this.conditionService = conditionService;
    }
    @Override
    public void run() {
        while (true) {
            conditionService.methodC();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
