package com.test.demo.zuul;

import com.netflix.zuul.FilterProcessor;
import com.test.demo.zuul.filter.AccessFilter;
import com.test.demo.zuul.processor.ZuulFilterProcessor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/13 11:21
 * @Update -
 * @Description
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {

    /**
     * 开启过滤规则
     *
     * @return
     */
    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

    /**
     * 自定义路由映射规则，如：helloservice-v1
     *
     * @return
     */
    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)", "${version}/${name}");
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
        FilterProcessor.setProcessor(new ZuulFilterProcessor());
    }
}
