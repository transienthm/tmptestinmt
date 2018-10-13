package org.java.bin.exam.涂鸦;

/**
 * Created by wangbin on 2017/8/25.
 */
public class LegalIP {

    public static void main(String[] args) {
        System.out.println(LegalIP.isLegalIp("192.2551.11.154"));
    }

    public static boolean isLegalIp(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String[] segments = str.split("\\.");
        if (segments.length != 4) {
            return false;
        }
        for (String s : segments) {
            if (!isLegalSegment(s)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLegalSegment(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int ip = 0;
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (num > 9 || num < 0) {
                return false;
            }
            ip = ip * 10 + num;
        }
        if (ip > 255 || ip < 0) {
            return false;
        }
        return true;
    }
}
