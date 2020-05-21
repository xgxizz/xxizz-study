package com.xu.springboottransactional.service.impl;

import com.xu.springboottransactional.entity.UserInfo;
import com.xu.springboottransactional.repository.UserInfoRepository;
import com.xu.springboottransactional.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserInfo save_required(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UserInfo save_requires_new(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public UserInfo save_supports(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
        //如果外层没有注解，内层直接使用非事务方式，此处发生的异常不会影响上一个插入操作
        userInfoRepository.save(new UserInfo("testsuports", null));

        return null;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public UserInfo save_not_supported(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public UserInfo save_never(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public UserInfo save_mandatory(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public UserInfo save_nested(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }
}
