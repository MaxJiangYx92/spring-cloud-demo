package com.test.demo.springboot.core.annotion;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/5 14:02
 * @Update -
 * @Description
 */
@Target({ElementType.TYPE,ElementType.METHOD})//注解作用于类和字段上
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Inherited
public @interface MyComponent {
    String value() default "";
}
