package com.test.demo.ribbon.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.test.demo.common.pojo.UserDO;
import com.test.demo.ribbon.service.UserService;
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

    static HystrixRequestContext context;

    @HystrixCollapser(batchMethod = "findAll", scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL, collapserProperties = {@HystrixProperty(name = "timerDelayInMilliseconds", value = "2000")})
    @Override
    public Future<UserDO> find2(String name) {
        context = HystrixRequestContext.initializeContext();
//        UserDO userDO = restTemplate.getForObject("http://HELLO-SERVICE/users/{1}", UserDO.class, name);
//        return userDO;
        return null;
    }

    @Override
    public UserDO find(String name) {
        System.out.println("find one " + name);
        UserDO user = new UserDO();
        user.setName("hello one");
        user.setSex("boy");
        user.setAge(18);
        return user;
    }

    @CacheResult
    @HystrixCommand(fallbackMethod = "findAllFallback")
    @Override
    public List<UserDO> findAll(List<String> names) {
        System.out.println("合并操作线程");
        System.out.println(names);
        List<UserDO> list = new ArrayList<>();
        for (String item : names) {
            System.out.println(item);
            UserDO userDO = new UserDO();
            userDO.setName(item);
//            System.out.println(item);
            list.add(userDO);
        }

        context.shutdown();
        return list;
        //restTemplate.getForObject("http://HELLO-SERVICE/users?names={1}", List.class, StringUtils.join(names, ","));
    }

    @Override
    public List<UserDO> findAll(String names) {
        System.out.println("合并操作线程");
        System.out.println(names);
        List<UserDO> list = new ArrayList<>();
        for (String item : names.split(",")) {
            UserDO userDO = new UserDO();
            userDO.setName(item);
            list.add(userDO);
        }
        return list;
        //restTemplate.getForObject("http://HELLO-SERVICE/users?names={1}", List.class, StringUtils.join(names, ","));
    }

    @HystrixCommand(fallbackMethod = "findAllFallback2")
    public List<UserDO> findAllFallback(List<String> names) {
        System.out.println("findAll first fallback");
        List<UserDO> list = new ArrayList<>();
        for (String item : names) {
            UserDO userDO = new UserDO();
            userDO.setName(item);
            list.add(userDO);
        }
        return list;
    }

    public List<UserDO> findAllFallback2(String names) {
        System.out.println("findAll second fallback");
        return new ArrayList<>();
    }
}
