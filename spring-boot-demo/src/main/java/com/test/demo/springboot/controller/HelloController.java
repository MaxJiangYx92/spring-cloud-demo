package com.test.demo.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/hello")
    public String index() {
        List<ServiceInstance> instance = client.getInstances("");
//        logger.info("/hello,host:" + instance.getHost() + ", service_id:" + instance.getServiceId());

//        List<String> services=client.getServices();
        for (ServiceInstance item : instance) {
            System.out.println("/hello,host:" + item.getHost() + ", service_id:" + item.getServiceId());
        }
//        System.out.println(client.getServices());
        return "hello spring boot";
    }
}
