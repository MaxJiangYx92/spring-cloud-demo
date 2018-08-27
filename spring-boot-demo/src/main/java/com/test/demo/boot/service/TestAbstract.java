package com.test.demo.boot.service;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/8/27 10:29
 * @Update -
 * @Description
 */
public abstract class TestAbstract {

    private String abstractName;

    public abstract void testAbstractFunc();

    public TestAbstract() {
        this.abstractName = "hello abstract";
    }

    public void init() {
        System.out.println("abstract public init");
    }

    public final void stop() {
        System.out.println("abstract public final stop");
    }
}
