package com.xu.study.reflect;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/19 10:12
 */
public class User {
    private String userName;
    private int age;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
