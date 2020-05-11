package com.xu.jwt.jwtdemo.controller;


import com.xu.jwt.jwtdemo.entity.Account;
import com.xu.jwt.jwtdemo.repository.SysUserService;
import com.xu.jwt.jwtdemo.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private SysUserService userService;


    @PostMapping(value="/login")
    @ResponseBody
    public Map<String,Object> login(String username,String password){

        Map<String,Object> map = new HashMap<>();
        Account user = new Account(username,password);

        if(userService.login(user)){
            String token = TokenUtil.sign(user);
            if(token != null){
                map.put("code", "10000");
                map.put("message", "认证成功");
                map.put("token", token);
                return map;
            }
        }

        map.put("code", "0000");
        map.put("message", "认证失败");
        return map;

    }

    @PostMapping(value="/getList")
    public List<Account> getList(){
        List userList = userService.getList();
        return userList;

    }

}