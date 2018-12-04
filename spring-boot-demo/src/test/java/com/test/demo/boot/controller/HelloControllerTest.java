//package com.test.demo.boot.controller;
//
//import com.test.demo.common.pojo.TestDO;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
///**
// * @author JiangYx
// * @Project
// * @Title
// * @Package
// * @Create 2018/6/8 18:05
// * @Update -
// * @Description
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@WebAppConfiguration
//public class HelloControllerTest {
//
//    //���ڵ���controller�Ľӿڷ�������performִ��һ������accept�������ͣ�andExpect�����жϽӿڵķ�������ֵ
//    private MockMvc mvc;
//
//    @Autowired
//    TestDO testDO;
////    @Bean
////    @ConfigurationProperties
////    public TestDO testDO() {
////        return new TestDO();
////    }//TODO: @ConfigurationProperties(prefix = "xxx")
//
//    @Before
//    public void setUp() throws Exception {
//        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
//    }
//
//    @Test
//    public void test() {
////        System.out.println(testDO.getName());
////        TestDO testDO = (TestDO) SpringContextUtil.getBean("testDO");
////        TestDO testDO = testDO();
//        System.out.println(testDO.getName());
//    }
//
////    @Test
////    public void hello() throws Exception {
////        mvc.perform(MockMvcRequestBuilders.get("/hello")
////                .accept(MediaType.APPLICATION_JSON))
////                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("hello spring boot")));
////    }
////
////    @Test
////    public void health() throws Exception {
////        System.out.println(mvc.perform(MockMvcRequestBuilders.get("/hello")).toString());
////
////    }
//}
