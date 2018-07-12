package com.test.demo.boot.controller;

import com.test.demo.common.pojo.UserDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

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

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    @RequestMapping(name = "/hello")
    public Mono<String> index() {
//        List<ServiceInstance> instance = client.getInstances("");
//        logger.info("/hello,host:" + instance.getHost() + ", service_id:" + instance.getServiceId());

//        List<String> services=client.getServices();
//        for (ServiceInstance item : instance) {
//            System.out.println("/hello,host:" + item.getHost() + ", service_id:" + item.getServiceId());
//        }

        String key = "hello_reactive_set";
        String value = "hello_reactive_value";
        reactiveRedisTemplate.opsForValue().set(key, value);

        logger.info("hello boot request");

        return Mono.just("hello reactive redis");
    }

    @RequestMapping("/nihao")
    public Mono<UserDO> nihao(@RequestParam("name") String name) {
        UserDO user = new UserDO();
        user.setAge(18);
        if (name != null) {
            user.setName(name);
        } else {
            user.setName("little god");
        }

        user.setSex("boy");
        return Mono.just(user);
    }
}
