package com.xu.study.javabase.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author xgx
 * @Date 2019/9/18 14:14
 */
public class Client {

    public void testMethodInterceptor(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SimpleClass.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("before method run...");
            Object object = methodProxy.invokeSuper(o,objects);
            System.out.println("after method run...");
            return object;
        });
        SimpleClass simple = (SimpleClass) enhancer.create();
        simple.test();
    }

    /*FixedValue用来对所有拦截的方法返回相同的值，从输出我们可以看出来，Enhancer对非final方法test()、toString()、hashCode()进行了拦截，没有对getClass进行拦截。
    由于hashCode()方法需要返回一个Number，但是我们返回的是一个String，这解释了上面的程序中为什么会抛出异常。
     */
    public void testFixedValue(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SimpleClass.class);
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "hello cglib ....";
            }
        });
        SimpleClass proxy = (SimpleClass) enhancer.create();
        System.out.println(proxy.test(null)); //拦截test，输出Hello cglib
        System.out.println(proxy.toString());
//        System.out.println(proxy.getClass());
//        System.out.println(proxy.hashCode());
    }

    public void testInvocationHandler() throws Exception{
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SimpleClass.class);
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getDeclaringClass() != Object.class && method.getReturnType() == String.class){
                    return "hello cglib";
                }else{
                    throw new RuntimeException("Do not know what to do");
                }
            }
        });
        SimpleClass proxy = (SimpleClass) enhancer.create();
        proxy.test();
//        Assert.assertEquals("hello cglib", proxy.test(null));
//        Assert.assertNotEquals("Hello cglib", proxy.toString());
    }

    public static void main(String[] args) throws Exception {
        new Client().testMethodInterceptor();
        new Client().testFixedValue();
        new Client().testInvocationHandler();
    }
}
