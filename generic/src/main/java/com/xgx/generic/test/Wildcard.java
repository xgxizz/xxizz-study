package com.xgx.generic.test;

import com.xgx.generic.entity.Generic;

/**
 * Description: <br/>
 *
 * @author: xgx <br/>
 * date: 2020/9/25 14:49 <br/>
 */
public class Wildcard {
    public void showKeyValue(Generic<Number> obj){
        System.out.println(obj.getKey());
    }

    //使用通配符'?'
    public void showKeyValue2(Generic<?> obj){
        System.out.println(obj.getKey());
    }

    public static void main(String[] args) {
        Generic<Integer> gInteger = new Generic<>(123);
        Generic<Number> gNumber = new Generic<>(456);
        Wildcard wildcard = new Wildcard();
        wildcard.showKeyValue(gNumber);//传入参数gInteger会报错
        //通过提示信息我们可以看到Generic<Integer>不能被看作为`Generic<Number>的子类。
        // 由此可以看出:同一种泛型可以对应多个版本（因为参数类型是不确定的），不同版本的泛型类实例是不兼容的。

        //如何解决上述问题呢---使用通配符'?'
        wildcard.showKeyValue2(gInteger);
    }
}
