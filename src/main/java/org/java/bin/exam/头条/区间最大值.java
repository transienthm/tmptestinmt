package org.java.bin.exam.头条;

/**
 * Created by wangbin on 2017/8/22.
 */
import java.util.*;
public class 区间最大值 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int res = 0;
        int min = 100;
        int length = 0;
        int recordLen = 0;
        while (start < arr.length && end < arr.length) {
            if (arr[start] == 0 || arr[end] == 0) {
                start = ++end;
                length = 0;
                min = 100;
                continue;
            }
            //计算sum
            sum += arr[end];
            if (arr[end] < min) {
                if (++length < recordLen) {
                    start = ++end;
                    length = 0;
                    min  = 100;
                    continue;
                }
                min = arr[end];
            }
            if (min * sum > res) {
                recordLen = length;
                res = min * sum;
            }
            end++;
        }
        System.out.println(res);
    }
}
