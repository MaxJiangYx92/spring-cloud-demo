package com.test.demo.springcloudribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.demo.common.pojo.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/17 17:49
 * @Update -
 * @Description
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {
        //Hystrix默认服务提供者超时为2秒，触发回调
        long start = System.currentTimeMillis();
        String result = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        long end = System.currentTimeMillis();
        return result;
    }

//    @HystrixCommand
//    public Future<UserDO> helloServiceAsync() {
//        return new AsyncResult<UserDO>() {
//            @Override
//            public UserDO invoke() {
//                return null;
//                //restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
//            }
//        };
//    }

    public String helloFallback() {
        return "hello error";
    }
}
