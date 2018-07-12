package com.test.demo.ribbon;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.test.demo.common.pojo.UserDO;
import com.test.demo.ribbon.command.UserCollapseCommand;
import com.test.demo.ribbon.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/19 12:25
 * @Update -
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HystrixTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void test() throws Exception {
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
    }

    @Test
    public void test2() throws Exception {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        System.out.println("hello test2");

//        Future<UserDO> f1 = userService.find2("123");
//        Future<UserDO> f2 = userService.find2("456");
//        Future<UserDO> f3 = userService.find2("789");
//        Thread.sleep(3000);
//        System.out.println("f1>>>" + f1.get());
//        System.out.println("f2>>>" + f2.get());
//        System.out.println("f3>>>" + f3.get());

        for (int i = 0; i < 10; i++) {
            userService.find2("123" + i);
        }
        Thread.sleep(3000);

//        System.out.println(userService.find("test1").get().toString());
//        System.out.println(userService.find("test2").get().toString());
//        System.out.println(userService.find("test3").get().toString());

        context.close();
    }
}
