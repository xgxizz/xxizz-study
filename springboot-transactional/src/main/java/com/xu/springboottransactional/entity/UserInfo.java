package com.xu.springboottransactional.entity;

import javax.persistence.*;

@Entity
@Table(name = "UserInfo")
public class UserInfo {
    @Id
    @GeneratedValue
    private Integer userId;

    @Column(length = 20)
    private String userName;

    @Column(nullable = false)
    private Integer age;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UserInfo(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    public UserInfo() {
    }
}
