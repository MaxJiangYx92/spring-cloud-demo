package com.test.demo.springcloudribbon.controller;

import com.test.demo.common.pojo.UserDO;
import com.test.demo.springcloudribbon.service.HelloService;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/14 17:16
 * @Update -
 * @Description
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "ribbon-hello1", method = RequestMethod.GET)
    public String hello1Consumer() {
        return helloService.helloService();
//                restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
    }

    @RequestMapping(value = "ribbon-hello2", method = RequestMethod.GET)
    public UserDO hello2Consumer() {
        HashMap<String, String> map = new HashMap<>(1);
        map.put("name", "little God");
        return restTemplate.getForEntity("http://HELLO-SERVICE/nihao?name={name}", UserDO.class, map).getBody();
    }

    @RequestMapping(value = "ribbon-hello3", method = RequestMethod.GET)
    public UserDO nihao3Consumer() {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://HELLO-SERVICE/nihao?name={name}")
                .build().expand("litle GOD").encode();
        URI uri = uriComponents.toUri();
        return restTemplate.getForEntity(uri, UserDO.class).getBody();
    }

    @RequestMapping(value = "ribbon-hello4", method = RequestMethod.GET)
    public UserDO nihao4Consumer() {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://HELLO-SERVICE/nihao?name={name}")
                .build().expand("litle GOD").encode();
        URI uri = uriComponents.toUri();
        UserDO userDO = restTemplate.getForObject(uri, UserDO.class);
        return userDO;
    }

    // TODO:postForEntity put delete
}
