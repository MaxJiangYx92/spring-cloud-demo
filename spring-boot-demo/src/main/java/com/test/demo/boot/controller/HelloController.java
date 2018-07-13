package com.test.demo.boot.controller;

import com.test.demo.common.pojo.UserDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/hello")
    public Mono<String> hello() throws Exception {

        //测试ribbon重试机制
        Thread.sleep(3000);

        //发现调用的服务
        client.getServices().forEach(id -> {
            client.getInstances(id).forEach(instance -> {
                logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
            });
        });

        String key = "hello_reactive_set";
        String value = "hello_reactive_value";
        reactiveRedisTemplate.opsForValue().set(key, value);

        logger.info("hello boot request");

        return Mono.just("hello reactive redis");
    }

    @RequestMapping(value = "/hello1")
    public Mono<String> hello1(@RequestParam("name") String name) {

        logger.info("hello1 boot request");

        return Mono.just("hello reactive " + name);
    }

    /**
     * //@RequestHeader,@RequestParam指定参数名称注解，value不能少，会抛IllegalStateException
     *
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/hello2")
    public Mono<UserDO> hello1(@RequestHeader(value = "name") String name, @RequestHeader(value = "age") Integer age) {

        logger.info("hello1 boot request");

        return Mono.just(new UserDO(name, "boy", age));
    }

    @RequestMapping(value = "/hello3")
    public Mono<String> hello3(@RequestBody UserDO userDO) {

        logger.info("hello1 boot request");

        return Mono.just("hello reactive userDO:name:" + userDO.getName() + "age:" + userDO.getAge());
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
