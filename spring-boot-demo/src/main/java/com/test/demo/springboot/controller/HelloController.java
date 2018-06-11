package com.test.demo.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/8 17:59
 * @Update -
 * @Description
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index() {
        return "hello spring boot";
    }
}
