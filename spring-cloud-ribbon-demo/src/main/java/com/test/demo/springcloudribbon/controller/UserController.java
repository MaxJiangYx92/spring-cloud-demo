package com.test.demo.springcloudribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.test.demo.common.pojo.UserDO;
import com.test.demo.springcloudribbon.command.UserCollapseCommand;
import com.test.demo.springcloudribbon.command.UserCommand;
import com.test.demo.springcloudribbon.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/19 9:55
 * @Update -
 * @Description
 */
@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserServiceImpl userService;

//    public UserController(){
//        HystrixRequestContext.initializeContext();
//    }

//    HystrixRequestContext context = HystrixRequestContext.initializeContext();

    @RequestMapping(value = "ribbon-users", method = RequestMethod.GET)
    public UserDO user1Consumer() throws Exception {
//        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        String name = "hello_hystrix";
//        return restTemplate.getForEntity("http://HELLO-SERVICE/users/{1}", UserDO.class, name).getBody();
//        UserDO userDO = userService.find(name);
        UserCollapseCommand u1 = new UserCollapseCommand(userService, name);
        u1.queue();

//        return userDO;
        return new UserDO();
    }

    @RequestMapping(value = "ribbon-users3", method = RequestMethod.GET)
    public String user3Consumer() throws Exception {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        System.out.println("hello test");

        UserCollapseCommand u1 = new UserCollapseCommand(userService, "123");
        UserCollapseCommand u2 = new UserCollapseCommand(userService, "456");
        UserCollapseCommand u3 = new UserCollapseCommand(userService, "789");
        Future<UserDO> f1 = u1.queue();
        Future<UserDO> f2 = u2.queue();
        Future<UserDO> f3 = u3.queue();
        Thread.sleep(3000);
        System.out.println("f1>>>" + f1.get());
        System.out.println("f2>>>" + f2.get());
        System.out.println("f3>>>" + f3.get());

//        System.out.println(userService.find("test1").get().toString());
//        System.out.println(userService.find("test2").get().toString());
//        System.out.println(userService.find("test3").get().toString());

        context.close();
        return "hello";
    }


//    @RequestMapping(value = "ribbon-users2/{name}", method = RequestMethod.GET)
//    @HystrixCollapser(batchMethod = "findAll1", scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL, collapserProperties = {@HystrixProperty(name = "timerDelayInMilliseconds", value = "2000")})
//    public Mono<UserDO> user2Consumer(@PathVariable(value = "name") String name) throws Exception {
//        String name1 = "hello hystrix";
//        UserDO userDO = new UserDO();
//        userDO.setName(name1);
////        return new Future<UserDO>() {
////            @Override
////            public boolean cancel(boolean mayInterruptIfRunning) {
////                return false;
////            }
////
////            @Override
////            public boolean isCancelled() {
////                return false;
////            }
////
////            @Override
////            public boolean isDone() {
////                return true;
////            }
////
////            @Override
////            public UserDO get() throws InterruptedException, ExecutionException {
////                return userDO;
////            }
////
////            @Override
////            public UserDO get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
////                return userDO;
////            }
////        };
//
//        return null;
//    }

//    //    @CacheResult
//    @HystrixCommand(fallbackMethod = "findAll1Fallback1")
//    public List<Mono<UserDO>> findAll1(List<String> names) {
//        System.out.println("合并操作线程");
////        List<UserDO> list = new ArrayList<>();
//        List<Mono<UserDO>> list = new ArrayList<>();
//        int i = 0;
//        for (String item : names) {
//            UserDO userDO = new UserDO();
//            userDO.setName(item + i);
//            System.out.println(item + i);
////            list.add(userDO);
//            Mono<UserDO> user = Mono.just(userDO);
//            list.add(user);
//            i++;
//        }
//        return list;
//    }

//    @HystrixCommand(fallbackMethod = "findAll1Fallback2")
//    public List<Mono<UserDO>> findAll1Fallback1(List<String> names) {
//        System.out.println("findAll first fallback");
////        List<UserDO> list = new ArrayList<>();
//        List<Mono<UserDO>> list = new ArrayList<>();
//        for (String item : names) {
//            UserDO userDO = new UserDO();
//            userDO.setName(item);
////            list.add(userDO);
//            list.add(Mono.just(userDO));
//        }
//        return list;
//    }

//    public List<UserDO> findAll1Fallback2(String names) {
//        System.out.println("findAll second fallback");
//        return new ArrayList<>();
//    }
}
