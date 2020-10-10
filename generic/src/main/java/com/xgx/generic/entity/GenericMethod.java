package com.xgx.generic.entity;

/**
 * @author: xgx <br/>
 * date: 2020/9/25 15:00 <br/>
 * Description:
 * <p>
 *
 *      * 这才是一个真正的泛型方法。
 *      * 首先在public与返回值之间的<T>必不可少，这表明这是一个泛型方法，并且声明了一个泛型T
 *      * 这个T可以出现在这个泛型方法的任意位置.
 *      * 泛型的数量也可以为任意多个
 *      *    如：public <T,K> K showKeyName(Generic<T> container){
 *      *        ...
 *      *        }
 *
 * </p>
 */


public class GenericMethod {

    public <T> T showKeyValue(Generic<T> container){
        System.out.println("container Key: " + container.getKey());
        T test = container.getKey();
        return test;
    }

    public <T> Integer showKeyValue2(Generic<T> obj){
        System.out.println("the number is :" + obj.getKey());
        if (obj.getKey() instanceof Integer){
            return (Integer) obj.getKey();
        }else {
            return null;
        }
    }

    //void 类型的泛型方法
    public <S, T> void show(S s, T t){
        System.out.println(s);
        System.out.println(t);
    }

    //泛型上下界
    public void showKeyValue1(Generic<? extends Number> obj){
        System.out.println("key value is " + obj.getKey());
    }

    //在泛型方法中添加上下边界限制的时候，必须在权限声明与返回值之间的<T>上添加上下边界，即在泛型声明的时候添加
    //public <T> T showKeyName(Generic<T extends Number> container)，编译器会报错："Unexpected bound"
    public <T extends Number> T showKeyName(Generic<T> container){
        System.out.println("container key :" + container.getKey());
        T test = container.getKey();
        return test;
    }

    public static void main(String[] args) {
        GenericMethod method = new GenericMethod();
        Generic<String> generic = new Generic<>("324234");
        method.showKeyValue(generic);
        Generic<Integer> generic1 = new Generic<>(new Integer(2332));
        System.out.println();
        method.showKeyValue2(generic1);

        String str = "str";
        Integer num = new Integer(1231);
        method.show(str, num);


        //泛型上下界
        Generic<String> generic0 = new Generic<>("11111");
        Generic<Integer> generic2 = new Generic<>(2222);
        Generic<Float> generic3 = new Generic<>(2.4f);
        Generic<Double> generic4 = new Generic<>(2.56);

        //这一行代码编译器会提示错误，因为String类型并不是Number类型的子类
        //method.showKeyValue1(generic0);

        method.showKeyValue1(generic2);
        method.showKeyValue1(generic3);
        method.showKeyValue1(generic4);
    }
}
