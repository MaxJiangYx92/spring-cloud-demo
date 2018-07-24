package com.test.demo.boot.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/24 13:55
 * @Update -
 * @Description
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver:" + hello);
    }
}
