package com.test.demo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/16 20:37
 * @Update -
 * @Description
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigApplication {
    public static void main(String[] args) {
//        new SpringApplicationBuilder(ConfigApplication.class).web(true).run(args);
        SpringApplication.run(ConfigApplication.class, args);
    }
}
