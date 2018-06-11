package com.test.demo.springcloudeureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.lang.instrument.Instrumentation;

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
public class Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
