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

    FreeTest() {
        System.out.println("this is construct method");
    }

    {
        System.out.println("this is code piece");
    }


    private static long test1(long x, long y) {
        long t;
        while (x % y > 0) {
            t = y;
            y = x % y;
            x = t;
        }
        return y;
    }

    private static boolean foo(char c) {
        System.out.println(c);
        return true;
    }

    public static void main(String[] args) {

//        System.out.println(test1(22,18));

//        int i = 0;
//        for (foo('A'); foo('B') && (i < 2); foo('C')) {
//            i++;
//            foo('D');
//        }

        try {
            System.out.println("try");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }


//        new FreeTest();
//        new FreeTest();
//
//        System.out.println("this is main one");
//
//        {
//            System.out.println("this is main two");
//        }
    }
}
