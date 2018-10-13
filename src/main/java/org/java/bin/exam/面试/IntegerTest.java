package org.java.bin.exam.面试;

/**
 * Created by wangbin on 2017/8/23.
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
        final char[] str = new char[]{'h', 'e', 'l', 'l', 'o'};
        System.out.println(str);
        str[3] = '5';
        System.out.println(str);
    }
}
