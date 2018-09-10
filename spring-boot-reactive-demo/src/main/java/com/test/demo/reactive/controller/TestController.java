package com.test.demo.reactive.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/9/5 15:16
 * @Update -
 * @Description
 */
@RestController
public class TestController {
    @RequestMapping(value = "/privatedata/portal/login", method = RequestMethod.POST)
    private void test(@RequestBody String body, @RequestHeader("cid") String cid) {
        System.out.println(body);
    }
}
