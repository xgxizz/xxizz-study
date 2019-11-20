package com.xu.study.thread.sync_block;

public class SynBlockThreadA implements Runnable {

    private SynBlock synBlock;

    public SynBlockThreadA(SynBlock synBlock) {
        this.synBlock = synBlock;
    }
    public void run() {
        synBlock.methodA();
    }
}
