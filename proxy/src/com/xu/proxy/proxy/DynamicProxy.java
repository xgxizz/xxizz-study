package com.xu.proxy.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
动态代理类
利用反射机制在运行时创建代理类。
接口、被代理类不变，我们构建一个handler类来实现InvocationHandler接口。
*/
public class DynamicProxy implements InvocationHandler {
    private Object object;

    //用于传入被代理类的构造器
    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke "  + method.getName());
        method.invoke(object, args);
        System.out.println("After invoke " + method.getName());
        return null;
    }
}
