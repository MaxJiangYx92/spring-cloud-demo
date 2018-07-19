package com.test.demo.config.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/19 10:11
 * @Update -
 * @Description
 */
@RefreshScope
@RestController
public class ConfigController {
    @Value("${from}")
    private String from;

    @Autowired
    private Environment environment;

    @RequestMapping("/from")
    public String from() {
        return environment.getProperty("from", "undefined");
    }

    @RequestMapping("/from1")
    public String from1() {
        return this.from;
    }
}
