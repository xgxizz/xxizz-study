package com.xu.jwt.jwtdemo.repository;

import com.xu.jwt.jwtdemo.entity.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService{

    @Override
    public boolean login(Account user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if(username.equals("king") && password.equals("123")){
            return true;
        }
        return false;
    }

    @Override
    public List<Account> getList() {

        Account user1= new Account("king1","12345");
        Account user2 = new Account("king2","12345");
        Account user3 = new Account("king3","12345");
        List<Account> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }
}