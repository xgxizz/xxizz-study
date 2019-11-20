package com.xu.study.annotation.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2019/2/25/025.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {
    String value() default  "first one";
}