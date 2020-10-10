package com.xgx.generic.entity;

/**
 * Description: <br/>
 *
 * @author: xgx <br/>
 * date: 2020/9/25 11:59 <br/>
 */
public class Pair2<T, U> {
    private T name;
    private U age;

    public Pair2(T name, U age) {
        this.name = name;
        this.age = age;
    }

    public Pair2() {
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public U getAge() {
        return age;
    }

    public void setAge(U age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pair2{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}
