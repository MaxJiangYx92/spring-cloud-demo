package com.test.demo.springcloudribbon.controller;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.test.demo.common.pojo.UserDO;
import com.test.demo.springcloudribbon.command.UserCollapseCommand;
import com.test.demo.springcloudribbon.command.UserCommand;
import com.test.demo.springcloudribbon.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.concurrent.Future;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/19 9:55
 * @Update -
 * @Description
 */
@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "ribbon-users", method = RequestMethod.GET)
    public UserDO user1Consumer() throws Exception {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        String name = "hello_hystrix";
//        return restTemplate.getForEntity("http://HELLO-SERVICE/users/{1}", UserDO.class, name).getBody();
        UserDO userDO = userService.find(name);
        context.close();
        return userDO;
    }

    @RequestMapping(value = "ribbon-users3", method = RequestMethod.GET)
    public String user3Consumer() throws Exception {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        System.out.println("hello test");

        UserCollapseCommand u1 = new UserCollapseCommand(userService, "123");
        UserCollapseCommand u2 = new UserCollapseCommand(userService, "456");
        UserCollapseCommand u3 = new UserCollapseCommand(userService, "789");
        Future<UserDO> f1 = u1.queue();
        Future<UserDO> f2 = u2.queue();
        Future<UserDO> f3 = u3.queue();
        Thread.sleep(3000);
        System.out.println("f1>>>" + f1.get());
        System.out.println("f2>>>" + f2.get());
        System.out.println("f3>>>" + f3.get());

//        System.out.println(userService.find("test1").get().toString());
//        System.out.println(userService.find("test2").get().toString());
//        System.out.println(userService.find("test3").get().toString());

        context.close();
        return "hello";
    }

//    @RequestMapping(value = "ribbon-users2", method = RequestMethod.GET)
//    public UserDO user2Consumer() throws Exception {
//        String name = "hello hystrix";
//        UserDO userDO = new UserCommand(restTemplate, name).execute();
//        return userDO;
//    }
}
