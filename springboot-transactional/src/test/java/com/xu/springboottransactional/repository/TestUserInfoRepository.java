package com.xu.springboottransactional.repository;

import com.xu.springboottransactional.entity.UserInfo;
import com.xu.springboottransactional.service.IUserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestUserInfoRepository {

    @Autowired
    private IUserInfoService userInfoService;
    @Test
    public void save(){
        userInfoService.save_required(new UserInfo("xgx",24));
    }
}
