package org.java.bin.exam.链家;

import java.util.Scanner;

/**
 * Created by wangbin on 2017/8/19.
 */

public class 小明排队 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] group = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = reader.nextInt();
        }
        int Q = reader.nextInt();
        int[] query = new int[Q];
        for (int i = 0; i < Q; i++) {
            query[i] = reader.nextInt();
        }

        int[] temp = new int[n];
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp += group[i];
            temp[i] = tmp;
        }

        int[] res = new int[Q];
        for (int i = 0; i < Q; i++) {
            for (int j = 0; j < n; j++) {
                if (query[i] <= temp[j]){
                    res[i] = j + 1;
                    break;
                }
            }
        }
        for (int i = 0; i < Q; i++) {
            System.out.println(res[i]);
        }

    }

    public static void printArr(int[] a){
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
