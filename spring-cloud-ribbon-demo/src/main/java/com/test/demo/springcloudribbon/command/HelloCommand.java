//package com.test.demo.springcloudribbon.command;
//
//import com.netflix.hystrix.HystrixCommand;
//import org.springframework.web.client.RestTemplate;
//
///**
// * @author JiangYx
// * @Project
// * @Title
// * @Package
// * @Create 2018/6/18 22:03
// * @Update -
// * @Description
// */
//public class HelloCommand extends HystrixCommand<String> {
//
//    private RestTemplate restTemplate;
//    private Long id;
//
//    public HelloCommand(Setter setter, RestTemplate restTemplate, Long id) {
//        super(setter);
//        this.restTemplate = restTemplate;
//        this.id = id;
//    }
//
//    @Override
//    protected String run() {
//        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
//    }
//}
