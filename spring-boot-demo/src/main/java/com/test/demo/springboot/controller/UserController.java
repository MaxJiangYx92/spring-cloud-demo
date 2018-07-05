package com.test.demo.springboot.controller;

import com.test.demo.common.pojo.UserDO;
import com.test.demo.springboot.service.TestAnnotation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/19 9:29
 * @Update -
 * @Description
 */
@RestController
public class UserController {
    @Autowired
    TestAnnotation testAnnotation;

    @RequestMapping("/users/{name}")
    public Mono<UserDO> find(@PathVariable("name") String name) {
        testAnnotation.print();
        System.out.println("this is single request");
        UserDO userDO = new UserDO();
        userDO.setSex("boy");
        userDO.setAge(18);
        userDO.setName(name);
        return Mono.just(userDO);
    }

    @RequestMapping("/users")
    public Mono<List<UserDO>> findAll(@RequestParam("names") String names) {
        System.out.println("this is merge request");
        List<UserDO> listUser = null;
        if (StringUtils.isEmpty(names)) {
            //new ArrayList<>();
        } else {
            String[] temp = names.split(",");
            listUser = new ArrayList<>();
            String[] sexs = {"boy", "girl", "man", "woman"};
            for (String name : temp) {
                UserDO userDO = new UserDO();
                userDO.setAge(18);
                userDO.setSex(sexs[(int) Math.random() * 5]);
                userDO.setName(name);
                listUser.add(userDO);
            }
        }
        return Mono.just(listUser);
    }
}
