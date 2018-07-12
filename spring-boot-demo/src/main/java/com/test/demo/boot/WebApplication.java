package com.test.demo.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/8 17:55
 * @Update -
 * @Description
 */
@EnableCaching
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.test.demo"})
//添加对aspect的支持
//@EnableAspectJAutoProxy
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
