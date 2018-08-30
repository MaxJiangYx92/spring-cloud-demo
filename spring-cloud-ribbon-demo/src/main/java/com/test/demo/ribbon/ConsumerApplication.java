package com.test.demo.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/14 17:14
 * @Update -
 * @Description
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
//@ServletComponentScan
public class ConsumerApplication {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        //解决转换中文失败
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
//        HystrixRequestContext.initializeContext();
//        HystrixRequestContext context = HystrixRequestContext.initializeContext();
    }
}
