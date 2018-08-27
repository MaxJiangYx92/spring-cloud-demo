package com.test.demo.boot.MyTests;

import com.test.demo.boot.WebApplication;
import com.test.demo.boot.config.MyConfig;
import com.test.demo.boot.core.support.MyApplicationSupport;
import com.test.demo.boot.service.impl.TestAbstractImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.WebApplicationObjectSupport;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/8/24 14:50
 * @Update -
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {WebApplication.class})
public class MyTest extends ApplicationObjectSupport {
//    @Autowired
//    private MyConfig myConfig;

//    @Autowired
//    private MyApplicationSupport myApplicationSupport;

    @Test
    public void test() {
//        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();

//        ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext();

//        ApplicationObjectSupport aos=new

//        WebApplicationObjectSupport

//        MyApplicationSupport myApplicationSupport = new MyApplicationSupport();
//        ApplicationContext applicationContext = myApplicationSupport.getApplicationContext();


        TestAbstractImpl testAbstract = new TestAbstractImpl();
        testAbstract.init();
        testAbstract.testAbstractFunc();
        testAbstract.testFunc1();
        testAbstract.stop();


//        if (true) {
//            System.out.println(((MyConfig) getApplicationContext().getBean("myConfig")).getName());
//        } else {
//            System.out.println("application context is null");
//        }

//        MyConfig myConfig = (MyConfig) applicationContext.getBean("myConfig");
//        System.out.println(myConfig.name);
    }
}
