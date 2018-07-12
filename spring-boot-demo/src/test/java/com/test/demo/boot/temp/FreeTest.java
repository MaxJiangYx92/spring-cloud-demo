package com.test.demo.boot.temp;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/10 13:52
 * @Update -
 * @Description
 */
public class FreeTest {
    static {
        System.out.println("this is static method");
    }

    FreeTest(){
        System.out.println("this is construct method");
    }

    {
        System.out.println("this is code piece");
    }

    public static void main(String[] args) {
        new FreeTest();
        new FreeTest();

        System.out.println("this is main one");

        {
            System.out.println("this is main two");
        }
    }
}
