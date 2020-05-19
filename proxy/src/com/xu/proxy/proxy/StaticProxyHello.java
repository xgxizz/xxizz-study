package com.xu.proxy.proxy;

import com.xu.IHelloInterface;
import com.xu.beproxy.Hello;

//代理类
//被代理类被传递给了代理类HelloProxy，代理类在执行具体方法时通过所持用的被代理类完成调用。
public class StaticProxyHello implements IHelloInterface {

    private IHelloInterface beproxy = new Hello();

    @Override
    public void syaHello() {
        System.out.println("Before invoke sayHello");
        beproxy.syaHello();
        System.out.println("After invoke sayHello");
    }
}
