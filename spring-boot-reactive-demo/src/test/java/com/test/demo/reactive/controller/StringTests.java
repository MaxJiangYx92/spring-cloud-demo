package com.test.demo.reactive.controller;

import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/9/4 9:33
 * @Update -
 * @Description
 */
public class StringTests {
    public static void main(String[] args) {
        WebClient webClient = WebClient.create("http://localhost:8088/");
        Mono<String> result = webClient.post().uri("hello").accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class);
        String monoResult = result.block();
        System.out.println(monoResult);
    }
}
