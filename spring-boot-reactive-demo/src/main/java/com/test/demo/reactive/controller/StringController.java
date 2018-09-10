package com.test.demo.reactive.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/9/3 14:57
 * @Update -
 * @Description
 */
@RestController
public class StringController {

    @Autowired
    private WebClient webClient;

    @RequestMapping(value = "/hello")
    public Mono<String> getWebClient() {
        try {
//            WebClient webClient = WebClient.create("http://localhost:8088/");
            Mono<String> result = webClient.get().uri("hello1?name={name}","helloName").accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class);
//            String monoResult = result.block();
//            System.out.println(monoResult);

//            WebClient.Builder
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return Mono.just("error");
    }

//    public static class Users{
//        private String name;
//    }
}
