package com.test.demo.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/19 10:04
 * @Update -
 * @Description
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientApplication {
    public static void main(String[] args) {
//        new SpringApplicationBuilder(ConfigClientApplication.class).web(true).run(args);
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
