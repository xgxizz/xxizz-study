package com.xu.springboottransactional.service.impl;

import com.xu.springboottransactional.entity.UserInfo;
import com.xu.springboottransactional.repository.UserInfoRepository;
import com.xu.springboottransactional.service.IPropagationService;
import com.xu.springboottransactional.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PropagationServiceImpl implements IPropagationService {

    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    @Transactional
    public void test_REQUIRED() {
        try {
            userInfoRepository.save(new UserInfo("REQUIRED_top", null));
        }catch (Exception e){

        }
        userInfoService.save_required(new UserInfo("REQUIRED_bottom", 11));
    }

    @Override
    @Transactional
    public void test_REQUIRES_NEW() {

        userInfoService.save_requires_new(new UserInfo("REQUIRES_NEW_bottom", 12));
        userInfoRepository.save(new UserInfo("REQUIRES_NEW_top", null));
    }

    @Override
    //@Transactional
    public void test_SUPPORTS() {
        userInfoService.save_supports(new UserInfo("SUPPORTS_bottom", 12));
        userInfoRepository.save(new UserInfo("SUPPORTS_top", 23));
    }

    @Override
    @Transactional
    public void test_NOT_SUPPORTED() {
        userInfoService.save_not_supported(new UserInfo("not_supported", 11));
        userInfoRepository.save(new UserInfo("not_supported", null));
    }

    @Override
    @Transactional
    public void test_NEVER() {
        userInfoService.save_never(new UserInfo("never", 22));
    }

    @Override
    public void test_MANDATORY() {
        userInfoService.save_mandatory(new UserInfo("mandatory",22));
    }

    @Override
    public void test_NESTED() {
        userInfoService.save_nested(new UserInfo("mandatory",22));
    }
}
