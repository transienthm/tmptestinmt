package org.java.bin.apache;


import org.apache.commons.lang3.StringUtils;

/**
 * Created by wangbin on 17/1/1.
 */
public class CommonsDemo {
    public static void main(String[] args) {
        String src = "abc";
        String repeat = StringUtils.repeat(src, 3);
        System.out.println(repeat);
        int n = StringUtils.countMatches(repeat, "ca");
        System.out.println(n);
    }
}
