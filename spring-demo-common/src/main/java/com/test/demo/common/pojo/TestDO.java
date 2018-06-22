package com.test.demo.common.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/21 10:30
 * @Update -
 * @Description
 */
@Configuration
public class TestDO {
    @Value("${test.name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
