package com.test.demo.springboot.controller;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/8 18:05
 * @Update -
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class HelloControllerTest {

    //���ڵ���controller�Ľӿڷ�������performִ��һ������accept�������ͣ�andExpect�����жϽӿڵķ�������ֵ
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

//    @Test
//    public void hello() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/hello")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("hello spring boot")));
//    }
//
//    @Test
//    public void health() throws Exception {
//        System.out.println(mvc.perform(MockMvcRequestBuilders.get("/hello")).toString());
//
//    }
}
