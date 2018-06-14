package com.test.demo.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/8 17:59
 * @Update -
 * @Description
 */
@RestController
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

//    @Autowired
//    private DiscoveryClient client;

    @Autowired
    private ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    @RequestMapping("/hello")
    public Mono<String> index() {
//        List<ServiceInstance> instance = client.getInstances("");
//        logger.info("/hello,host:" + instance.getHost() + ", service_id:" + instance.getServiceId());

//        List<String> services=client.getServices();
//        for (ServiceInstance item : instance) {
//            System.out.println("/hello,host:" + item.getHost() + ", service_id:" + item.getServiceId());
//        }

        reactiveRedisTemplate.opsForSet().add("reactive_key", "hello reactive value");
//        reactiveRedisTemplate.opsForSet().
        return Mono.just("hello spring boot");
    }

    @RequestMapping("/nihao")
    public Mono<Boolean> addLink() {
        String key = "hello_reactive_set";
        String value = "hello_reactive_value";
        return reactiveRedisTemplate.opsForValue().set(key, value);
    }
}
