package org.java.bin.demo;

/**
 * Created by wangbin on 2017/7/11.
 */
public class LambdaDemo {
    public static void main(String[] args) {

        new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();
    }
}
