//package com.test.demo.feign.config;
//
//import feign.Feign;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//
///**
// * @author JiangYx
// * @Project
// * @Title
// * @Package
// * @Create 2018/7/13 10:11
// * @Update -
// * @Description
// */
//@Configuration
//public class DisableHystrixConfiguration {
//
//    @Bean
//    @Scope("prototype")
//    public Feign.Builder feignBuilder() {
//        //通过@Scope("prototype")为指定的客户端配置Feign.Builder实例
//        return Feign.builder();
//    }
//
//}
