package com.xu.beproxy;

import com.xu.IHelloInterface;

//被代理对象
public class Hello implements IHelloInterface {
    @Override
    public void syaHello() {
        System.out.println("hello xuguoxing");
    }
}
