package com.test.demo.springcloudribbon.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.test.demo.common.pojo.UserDO;
import com.test.demo.springcloudribbon.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static com.netflix.hystrix.HystrixCommandGroupKey.Factory.asKey;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/19 10:02
 * @Update -
 * @Description
 */
public class UserBatchCommand extends HystrixCommand<List<UserDO>> {

    UserService userService;
    String names;

    public UserBatchCommand(UserService userService, String names) {
        super(Setter.withGroupKey(asKey("userServiceCommand")));
        this.userService = userService;
        this.names = names;
    }

    @Override
    protected List<UserDO> run() throws Exception {
        return userService.findAll(names);
    }

    @Override
    public List<UserDO> getFallback() {
        return new ArrayList<>();
    }
}
