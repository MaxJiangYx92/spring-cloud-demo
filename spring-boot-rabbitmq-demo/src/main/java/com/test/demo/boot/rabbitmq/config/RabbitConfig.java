package com.test.demo.boot.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/24 13:57
 * @Update -
 * @Description
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }
}
