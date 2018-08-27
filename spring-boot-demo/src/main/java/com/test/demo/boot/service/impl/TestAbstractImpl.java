package com.test.demo.boot.service.impl;

import com.test.demo.boot.service.TestAbstract;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/8/27 10:39
 * @Update -
 * @Description
 */
public class TestAbstractImpl extends TestAbstract {

    @Override
    public void testAbstractFunc() {
        System.out.println("impl override testAbstractFunc");
    }

    public void testFunc1() {
        System.out.println("impl testFunc1");
    }
}
