package com.xu.thread.join;

public class Service extends Thread{

    public Service(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println(this.getName() + "----->"+i);
        }
    }
}
