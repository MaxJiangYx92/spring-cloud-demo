package com.test.demo.feign;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/21 9:45
 * @Update -
 * @Description
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignApplication {

    @Bean
    Logger.Level feignLoggerLevel(){
        // 客户端默认loggin.level是none级别
        // NONE:不记录任何信息
        // BASIC:仅记录请求方法、url以及响应状态码和执行时间
        // HEADERS:除了记录BASIC信息之外，还记录请求和响应的头信息
        // FULL:记录所有请求和响应的明细，包括头信息，请求体，元数据等
        return Logger.Level.FULL;
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }
}
