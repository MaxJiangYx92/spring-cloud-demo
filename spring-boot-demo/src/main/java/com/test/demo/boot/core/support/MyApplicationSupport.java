package com.test.demo.boot.core.support;

import com.test.demo.boot.config.MyConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/8/24 15:31
 * @Update -
 * @Description
 */
@Component
public class MyApplicationSupport extends ApplicationObjectSupport {
    private static ApplicationContext context;

    public MyApplicationSupport() {
        super();
    }

    public void setContext() {
        if (context == null) {
            MyApplicationSupport.context = getApplicationContext();
        }
    }

    public static MyConfig getMyConfig() {

        return (MyConfig) context.getBean("myConfig");
    }

}
