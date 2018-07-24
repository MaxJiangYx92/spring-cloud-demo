package com.test.demo.boot.rabbitmq.productor;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/24 11:27
 * @Update -
 * @Description
 */
@Component
public class Sender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String context = "hello" + new Date();
        System.out.println("Sender:" + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }
}
