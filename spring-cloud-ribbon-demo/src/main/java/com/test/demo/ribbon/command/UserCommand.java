package com.test.demo.ribbon.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.test.demo.common.pojo.UserDO;
import org.springframework.web.client.RestTemplate;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/19 14:22
 * @Update -
 * @Description
 */
public class UserCommand extends HystrixCommand<UserDO> {

    private RestTemplate restTemplate;
    private String name;

    public UserCommand(RestTemplate restTemplate, String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("UserGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("UserCommand")));
        this.restTemplate = restTemplate;
        this.name = name;
    }

    @Override
    public UserDO run() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/users/{1}", UserDO.class, name).getBody();
    }

    @Override
    public UserDO getFallback() {
        return new UserDO();
    }

    @Override
    public String getCacheKey() {
        return String.valueOf(name);
    }
}
