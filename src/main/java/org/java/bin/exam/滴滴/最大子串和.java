package org.java.bin.exam.滴滴;

import java.util.Scanner;

/**
 * Created by wangbin on 2017/8/26.
 */
public class 最大子串和 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String str = reader.nextLine();
        String[] numStr = str.split(" ");
        int n = numStr.length;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(numStr[i]);
        }
        System.out.println(maxSubSequence(arr));
    }

    private static long maxSubSequence(long a[]) {
        long maxsum, maxhere;
        maxsum = maxhere = a[0];   //初始化最大和为a【0】
        for (int i = 1; i < a.length; i++) {
            if (maxhere <= 0)
                maxhere = a[i];  //如果前面位置最大连续子序列和小于等于0，则以当前位置i结尾的最大连续子序列和为a[i]
            else
                maxhere += a[i]; //如果前面位置最大连续子序列和大于0，则以当前位置i结尾的最大连续子序列和为它们两者之和
            if (maxhere > maxsum) {
                maxsum = maxhere;  //更新最大连续子序列和
            }
        }
        return maxsum;
    }
}
