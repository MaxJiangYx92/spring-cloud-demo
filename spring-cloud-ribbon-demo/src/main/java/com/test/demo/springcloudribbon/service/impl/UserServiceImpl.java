package com.test.demo.springcloudribbon.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.test.demo.common.pojo.UserDO;
import com.test.demo.springcloudribbon.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/19 9:57
 * @Update -
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCollapser(batchMethod = "findAll", scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL, collapserProperties = {@HystrixProperty(name = "timerDelayInMilliseconds", value = "100")})
    @Override
    public UserDO find(String name) {
//        UserDO userDO = restTemplate.getForObject("http://HELLO-SERVICE/users/{1}", UserDO.class, name);
//        return userDO;
        return null;
    }

    @CacheResult
    @HystrixCommand(fallbackMethod = "findAllFallback")
    @Override
    public List<UserDO> findAll(String names) {
        System.out.println("合并操作线程");
        System.out.println(names);
        return new ArrayList<>();
        //restTemplate.getForObject("http://HELLO-SERVICE/users?names={1}", List.class, StringUtils.join(names, ","));
    }

    @HystrixCommand(fallbackMethod = "findAllFallback2")
    public List<UserDO> findAllFallback(String names) {
        System.out.println("findAll first fallback");
        return new ArrayList<>();
    }

    public List<UserDO> findAllFallback2(String names) {
        System.out.println("findAll second fallback");
        return new ArrayList<>();
    }
}
