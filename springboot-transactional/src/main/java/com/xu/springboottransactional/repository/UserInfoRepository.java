package com.xu.springboottransactional.repository;

import com.xu.springboottransactional.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;


public interface UserInfoRepository extends CrudRepository<UserInfo, Integer> {

}
