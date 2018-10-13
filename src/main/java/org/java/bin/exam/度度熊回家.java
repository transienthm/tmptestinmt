package org.java.bin.exam;

import java.util.Scanner;

/**
 * Created by wangbin on 2017/8/14.
 */
public class 度度熊回家 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        if (n < 2){
            System.out.println(-1);
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }

        int sum = 0;
        int badSum = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 1; i < n; i++) {
            sum += getdist(arr[i - 1], arr[i]);
            if (i != n - 1) {
                int temp = getdist(arr[i - 1],arr[i]) + getdist(arr[i + 1],arr[i]);
                boolean flag = temp > badSum;
                badSum = (flag) ? temp : badSum;
                index = (flag) ? i : index;
            }
        }
        int path = getdist(arr[index - 1], arr[index + 1]);
        System.out.println(sum - badSum + path);
    }

    public static int getdist(int a, int b) {
        return Math.abs(a - b);
    }
}
