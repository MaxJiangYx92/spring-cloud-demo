package com.test.demo.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    /**
     * Question1:hystrix方法一，非注解版
     * @return
     */
//    public String helloService(){
//        String hello=new HelloCommand(restTemplate,1L).execute();
//    }

    /**
     * hystrix方法二，注解版
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {
        //Hystrix默认服务提供者超时为2秒，触发回调
        long start = System.currentTimeMillis();
        String result = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        long end = System.currentTimeMillis();
        return result;
    }

    /**
     * Question2:
     * @return
     */
//    @HystrixCommand
//    public Future<UserDO> helloServiceAsync() {
//        return new AsyncResult<UserDO>() {
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
