package com.xu.proxy;

import com.xu.proxy.proxy.StaticProxyHello;

public class TestStaticProxy {

    public static void main(String[] args) {
        StaticProxyHello proxyHello = new StaticProxyHello();
        proxyHello.syaHello();
    }
}

/*
* 输出：
    Before invoke sayHello
    Hello zhanghao!
    After invoke sayHello
* */
