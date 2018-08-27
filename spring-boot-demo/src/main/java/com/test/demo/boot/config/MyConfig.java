package com.test.demo.boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/8/24 14:45
 * @Update -
 * @Description
 */
@Configuration
@ConfigurationProperties(prefix = "demo.test")
public class MyConfig {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
