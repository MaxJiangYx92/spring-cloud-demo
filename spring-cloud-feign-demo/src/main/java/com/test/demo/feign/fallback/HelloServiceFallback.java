package com.test.demo.feign.fallback;

import com.test.demo.common.pojo.UserDO;
import com.test.demo.feign.service.HelloService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/13 10:19
 * @Update -
 * @Description
 */
@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public UserDO hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new UserDO("未知", "未知", 0);
    }

    @Override
    public String hello(@RequestParam("name") String name) {
        return "error";
    }

    @Override
    public String hello(@RequestBody UserDO userDO) {
        return "error";
    }
}
