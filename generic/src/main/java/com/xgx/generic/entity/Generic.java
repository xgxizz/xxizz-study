package com.xgx.generic.entity;

/**
 * Description: <br/>
 //此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
 //在实例化泛型类时，必须指定T的具体类型
 * @author: xgx <br/>
 * date: 2020/9/25 14:51 <br/>
 */
public class Generic<T> {
    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    //虽然在方法中使用了泛型，但是这并不是一个泛型方法。
    //这只是类中一个普通的成员方法，只不过他的返回值是在声明泛型类已经声明过的泛型。
    //所以在这个方法中才可以继续使用 T 这个泛型。
    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }

    // * 这个方法显然是有问题的，在编译器会给我们提示这样的错误信息"cannot reslove symbol E"
    // * 因为在类的声明中并未声明泛型E，所以在使用E做形参和返回值类型时，编译器会无法识别。
   /* public E setKey(E key){
        this.key = key;
    }*/


}
