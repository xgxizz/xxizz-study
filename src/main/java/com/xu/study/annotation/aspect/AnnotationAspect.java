package com.xu.study.annotation.aspect;

import com.xu.study.annotation.annotation.MyAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author xgx
 * @Date 2019/8/27 18:23
 */
@Aspect
@Component
public class AnnotationAspect {

    @Pointcut("@annotation(com.xu.study.annotation.annotation.MyAnnotation)")
    public void addAdvice(){ }

    @Around("addAdvice()")
    public Object Interceptor(ProceedingJoinPoint joinPoint){
        System.out.println("====Interceptor====");
        System.out.println("通知之开始");
        Object retmsg=null;
        try {
            retmsg = joinPoint.proceed();
            System.err.println("++++++++"+retmsg);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("通知之结束 +retmsg+" + retmsg);

        Object result = null;
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            String deviceId = (String) args[0];
            if (!"03".equals(deviceId)) {
                return "no anthorization";
            }
        }
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }
    @Before("addAdvice()")
    public void before(JoinPoint joinPoint){
        MethodSignature sign =  (MethodSignature)joinPoint.getSignature();
        Method method = sign.getMethod();
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        System.out.println("打印：" + annotation.value() + " 开始前");
        //System.out.println("===开始前===");
    }

    @After("addAdvice()")
    public void after() {
        System.out.println("after方法执行后");
    }
}
