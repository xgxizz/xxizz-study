package com.xu.study.javabase.proxy.jdk_dynamic_proxy;

import java.lang.reflect.Proxy;

/**
 * 调用类
 * @author gnehcgnaw
 * @date 2018/11/7 20:26
 */
public class Client {
    public static void main(String[] args) {
        //真实对象
        Subject realSubject =  new RealSubject();

        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(realSubject);
        //代理对象
        Subject proxyClass = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Subject.class}, myInvocationHandler);

        proxyClass.sellBooks();

        proxyClass.speak();
    }
}