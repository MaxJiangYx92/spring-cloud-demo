package com.test.demo.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/10 22:42
 * @Update -
 * @Description
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

    final Logger logger = LoggerFactory.getLogger(EurekaApplication.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaApplication.class).web(true).run(args);
    }
}
