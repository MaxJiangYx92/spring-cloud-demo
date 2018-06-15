package com.test.demo.springcloudribbon.controller;

import com.test.demo.common.pojo.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @RequestMapping(value = "ribbon-hello", method = RequestMethod.GET)
    public String helloConsumer() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
    }

    @RequestMapping(value = "ribbon-nihao", method = RequestMethod.GET)
    public UserDO nihaoConsumer() {
        HashMap<String,String> map=new HashMap<>(1);
        map.put("name","little God");
        return restTemplate.getForEntity("http://HELLO-SERVICE/nihao?name={name}", UserDO.class,map).getBody();
    }
}
