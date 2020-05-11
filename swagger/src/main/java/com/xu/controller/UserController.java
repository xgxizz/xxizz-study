package com.xu.controller;

import com.alibaba.fastjson.JSONObject;
import com.xu.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author xgx
 * @Date 2020/1/9 10:15
 */
@Api(tags = "用户管理", value = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation("用户详情")
    @PostMapping("/info")
    public String getUser(){
        User user = new User();
        user.setId(1);
        user.setName("xuguoxing");
        return JSONObject.toJSONString(user);
    }

}
