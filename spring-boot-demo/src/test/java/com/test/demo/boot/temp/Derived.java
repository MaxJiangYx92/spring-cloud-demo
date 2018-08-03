package com.test.demo.boot.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/8/2 13:37
 * @Update -
 * @Description
 */
public class Derived extends Base {

    String objType = "s";

    public Derived() {
        super(1);
        objType = "i am de type";
    }

    public String get() {
        return this.objType;
    }

    public static void fun(String[] arrA, String[] arrB) {
        List<String> arrTemp = new ArrayList<>();
        for (int i = 0; i < arrB.length; i++) {

//            if (Arrays.stream(arrA).anyMatch(j -> arrB[i].equals(j))) {
//                System.out.println(arrB[i]);
//                continue;
//            }
            arrTemp.add(arrB[i]);
        }
    }

    public static void main(String[] args) {

        String[] arrA = {"c", "b", "d"};
        String[] arrB = {"a", "b", "c"};
        fun(arrA, arrB);


//        Base d = new Derived();
//        System.out.println(d.get());
//        System.out.println(d.get2());
    }
}
