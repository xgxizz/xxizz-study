package com.xu.proxy.proxy;

import com.xu.IByeInterface;
import com.xu.IHelloInterface;
import com.xu.beproxy.Bye;
import com.xu.beproxy.Hello;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


/**
 * 通过实现 InvocationHandler 接口创建自己的调用处理器；
 * 通过为 Proxy 类指定 ClassLoader 对象和一组 interface 来创建动态代理类；
 * 通过反射机制获得动态代理类的构造函数，其唯一参数类型是调用处理器接口类型；
 * 通过构造函数创建动态代理类实例，构造时调用处理器对象作为参数被传入。
 */
public class TestDynamicProxy {
    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        //创建被代理实例
        IHelloInterface hello = new Hello();
        IByeInterface bye = new Bye();

        InvocationHandler handler1 = new DynamicProxy(hello);
        InvocationHandler handler2 = new DynamicProxy(bye);

        IHelloInterface proxyHello = (IHelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler1);
        IByeInterface proxyBye = (IByeInterface) Proxy.newProxyInstance(bye.getClass().getClassLoader(), bye.getClass().getInterfaces(), handler2);
        proxyHello.syaHello();
        proxyBye.sayBye();
    }
}
