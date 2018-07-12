package com.test.demo.feign.controller;

import com.test.demo.feign.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/11 17:26
 * @Update -
 * @Description
 */
@RestController
public class ConsumerController {

    final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        logger.info("hello feign consumer");
        return helloService.hello();
    }
}
