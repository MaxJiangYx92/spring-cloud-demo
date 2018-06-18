package com.test.demo.springcloudribbon.service;

import com.netflix.hystrix.HystrixCommand;
import com.test.demo.common.pojo.UserDO;
import org.springframework.web.client.RestTemplate;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/18 22:03
 * @Update -
 * @Description
 */
public class UserCommand extends HystrixCommand<UserDO> {

    private RestTemplate restTemplate;
    private Long id;

    public UserCommand(Setter setter, RestTemplate restTemplate, Long id) {
        super(setter);
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected UserDO run() {
        return restTemplate.getForObject("http://HELLO-SERVICE/nihao?name={1}", UserDO.class, "OX");
    }
}
