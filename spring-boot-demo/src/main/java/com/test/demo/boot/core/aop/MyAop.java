package com.test.demo.boot.core.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/6 16:22
 * @Update -
 * @Description
 */
@Aspect
@Component
public class MyAop {
    @Pointcut(value = "@annotation(com.test.demo.boot.core.annotion.MyComponent)")
    public void myAop() {
        System.out.println("hello my aop");
    }

    @Before("myAop()")
    public void before() {
        System.out.println("this is my aop before method");
//        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
//        Method method = sign.getMethod();
//        MyComponent annotation = method.getAnnotation(MyComponent.class);
//        System.out.print("打印：" + annotation.value() + " 前置日志");
    }

    @Around("myAop()")
    public void around() {
        System.out.println("this is my aop around method");
    }

    @After("myAop()")
    public void after() {
        System.out.println("this is my aop after method");
    }

}
