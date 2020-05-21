package com.xu.springboottransactional.service;

import com.xu.springboottransactional.entity.UserInfo;

public interface IUserInfoService {

    UserInfo save_required(UserInfo userInfo);

    UserInfo save_requires_new(UserInfo userInfo);

    UserInfo save_supports(UserInfo userInfo);

    UserInfo save_not_supported(UserInfo userInfo);

    UserInfo save_never(UserInfo userInfo);

    UserInfo save_mandatory(UserInfo userInfo);

    UserInfo save_nested(UserInfo userInfo);
}
