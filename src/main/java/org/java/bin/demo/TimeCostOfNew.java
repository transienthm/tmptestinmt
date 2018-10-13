package org.java.bin.demo;


/**
 * Created by wangbin on 2017/11/14.
 */
public class TimeCostOfNew {
    static int count = 10000000;
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            new String(String.valueOf(Integer.valueOf(i).byteValue()));
        }
        long end = System.currentTimeMillis();
        System.out.println("new cost = " + (end - start));


        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {

        }
        end = System.currentTimeMillis();
        System.out.println("loop cost = " + (end - start));

    }
}
