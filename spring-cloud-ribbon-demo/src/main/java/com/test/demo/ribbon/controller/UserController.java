package com.test.demo.ribbon.controller;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.test.demo.common.pojo.UserDO;
import com.test.demo.ribbon.command.UserCollapseCommand;
import com.test.demo.ribbon.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.*;

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

//    @Before(value = "user1Consumer")
//    public void initRequestContext(){
//        HystrixRequestContext context = HystrixRequestContext.initializeContext();
//    }

    @RequestMapping(value = "ribbon-users", method = RequestMethod.POST)
    public UserDO user1Consumer(@RequestBody String body) throws Exception {
//        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        String name = "hello_hystrix";
//        return restTemplate.getForEntity("http://HELLO-SERVICE/users/{1}", UserDO.class, name).getBody();
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                userService.find2(name);
//            }
//        });
//        executorService.shutdown();
//        while (true) {
//            if (executorService.isTerminated()) {
//                System.out.println("all thread is terminated");
//                context.close();
//                break;
//            }
//            Thread.sleep(500);
//        }

        //hystrix test
//        userService.find2(name);

//        Thread.sleep(2000);
//        context.close();

//        UserCollapseCommand u1 = new UserCollapseCommand(userService, name);
//        u1.queue();

//        return userDO;

        System.out.println("this is body : " + body);

        UserDO userDO = new UserDO();
        userDO.setName("users1Consumer");
        return userDO;
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

    @RequestMapping(value = "ribbon-users4", method = RequestMethod.GET)
    public String user4Consumer() throws Exception {

        ResponseEntity<String> response =restTemplate.postForEntity("http://API-GATEWAY/test/api-c/hello1?accessToken=hello", "hello test body", String.class);
        System.out.println(response.getBody());
        return "ok";
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
