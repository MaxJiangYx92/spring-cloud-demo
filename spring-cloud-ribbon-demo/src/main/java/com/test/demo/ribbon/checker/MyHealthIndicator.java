package com.test.demo.ribbon.checker;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/15 14:08
 * @Update -
 * @Description
 */
@Component
public class MyHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        //自定义监控内容
        return new Health.Builder().withDetail("consumer", "client is up").up().build();
    }
}
