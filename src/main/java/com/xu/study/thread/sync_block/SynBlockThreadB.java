package com.xu.study.thread.sync_block;

public class SynBlockThreadB implements Runnable {

    private SynBlock synBlock;

    public SynBlockThreadB(SynBlock synBlock) {
        this.synBlock = synBlock;
    }
    public void run() {
        synBlock.methodB();
    }
}
