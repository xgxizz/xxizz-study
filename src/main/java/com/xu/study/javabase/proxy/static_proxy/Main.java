package com.xu.study.javabase.proxy.static_proxy;

/**
 * @Description
 * @Author xgx
 * @Date 2019/9/16 16:24
 */
public class Main {
    public static void main(String[] args) {
        Image proxy = new ImageProxy("c:\\aa.png");
        proxy.display();
    }
}
