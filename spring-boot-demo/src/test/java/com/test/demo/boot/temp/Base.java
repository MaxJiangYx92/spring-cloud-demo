package com.test.demo.boot.temp;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/8/2 13:35
 * @Update -
 * @Description
 */
public class Base {
    String objType = "f";

    public Base(int i) {
        objType = "I am a Base type";
    }

    String get() {
        return this.objType;
    }

    public String get2() {
        return this.objType;
    }
}
