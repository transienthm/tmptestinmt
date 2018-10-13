package org.java.bin.jvm;

import java.util.Stack;

/**
 * Created by wangbin on 17/1/22.
 */
public class Demo01 {
    public static void main(String[] args) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        System.out.println(cl);
        System.out.println(cl.getParent());
        System.out.println(cl.getParent().getParent());

        String[] cp = System.getProperty("java.class.path").split(":");
        for (String str : cp) {
            System.out.println(str);
        }
    }
}
