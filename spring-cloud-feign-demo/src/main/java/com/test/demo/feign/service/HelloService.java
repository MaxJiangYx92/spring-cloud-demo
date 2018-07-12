package com.test.demo.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
