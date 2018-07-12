package com.test.demo.feign.service;

import com.test.demo.common.pojo.UserDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/11 17:22
 * @Update -
 * @Description
 */
@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    UserDO hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "hello1", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "hello3", method = RequestMethod.POST)
    String hello(@RequestBody UserDO userDO);

}
