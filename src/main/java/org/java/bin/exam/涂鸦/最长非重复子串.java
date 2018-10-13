package org.java.bin.exam.涂鸦;

/**
 * Created by wangbin on 2017/8/25.
 */
public class 最长非重复子串 {
    public static void main(String[] args) {
        System.out.println(最长非重复子串.lengthOfLongestSubstring("120135435"));
    }
    public static String lengthOfLongestSubstring(String s) {
        int[] map = new int[10];
        int j = 0;
        int i = 0;
        int max = 0;
        int start = 0;
        int end = 0;
        for (i = 0; i < s.length(); i++) {
            while (j < s.length() && map[s.charAt(j) - '0'] == 0) {
                map[s.charAt(j) - '0'] = 1;
                if ((j - i + 1) > max) {
                    max = j - i + 1;
                    start = i;
                    end = j;
                }
                j++;
            }
            map[s.charAt(i) - '0'] = 0;
        }

        return s.substring(start, end + 1);
    }
}
