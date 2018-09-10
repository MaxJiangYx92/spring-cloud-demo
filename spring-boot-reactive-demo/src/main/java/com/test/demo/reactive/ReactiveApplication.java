package com.test.demo.reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/9/3 14:56
 * @Update -
 * @Description
 */
@EnableDiscoveryClient
@SpringBootApplication//(scanBasePackages = {"com.test.demo"})
public class ReactiveApplication {

    @Autowired
    private LoadBalancerExchangeFilterFunction lbFunction;

    /**
     * webClient的loadBalanced支持比restTemplate更为简洁和清晰，直接使用filter模式，
     * 通过loadBalancerClient获取服务地址，替换uri再传递给下一个filter。
     * 如果loadBalancerClient没能获得到服务地址的话，
     * 则RibbonLoadBalancerClient.reconstructURI方法会报错java.lang.IllegalArgumentException: instance can not be null。
     * 另外由于注册中心的信息可能有延迟，因为也可能存在Connection refused的异常。
     * @return
     */
    @Bean
    WebClient webClient(){
        return WebClient.builder().baseUrl("http://HELLO-SERVICE/").filter(lbFunction).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(ReactiveApplication.class, args);
    }
}
