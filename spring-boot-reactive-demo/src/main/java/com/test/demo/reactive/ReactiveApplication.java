package com.test.demo.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/9/3 14:56
 * @Update -
 * @Description
 */
@EnableDiscoveryClient
@SpringBootApplication//(scanBasePackages = {"com.test.demo"})
public class ReactiveApplication {

    @Bean
    @LoadBalanced
    WebClient webClient(){
        return WebClient.builder().baseUrl("http://HELLO-SERVICE/").build();
    }

    public static void main(String[] args) {
        SpringApplication.run(ReactiveApplication.class, args);
    }
}
