package com.xu.jwt.jwtdemo.repository;


import com.xu.jwt.jwtdemo.entity.Account;

import java.util.List;

public interface SysUserService {

    public boolean login(Account user);

    public List<Account> getList();
}