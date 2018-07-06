package com.test.demo.springboot.controller;

import com.test.demo.springboot.core.annotion.MyComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/6 16:36
 * @Update -
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MyAopTest {

//    @MyComponent("hello_aop")
    private String test;

    @Test
    @MyComponent("hello")
    public void test() {
//        Field[] fields = MyAopTest.class.getDeclaredFields();
//        for(Field field : fields){
//            boolean fieldHasAnno = field.isAnnotationPresent(MyComponent.class);
//            if(fieldHasAnno){
//                MyComponent fieldAnno = field.getAnnotation(MyComponent.class);
//                //输出注解属性
//                System.out.println(fieldAnno.value());
//            }
//        }
        System.out.println("hello test");
        //解析方法上的注解
//        Method[] methods = clz.getDeclaredMethods();
//        for(Method method : methods){
//            boolean methodHasAnno = method.isAnnotationPresent(MethodAnnotation.class);
//            if(methodHasAnno){
//                //得到注解
//                MethodAnnotation methodAnno = method.getAnnotation(MethodAnnotation.class);
//                //输出注解属性
//                String desc = methodAnno.desc();
//                System.out.println(method.getName() + " desc = " + desc);
//            }
//        }
    }

}
