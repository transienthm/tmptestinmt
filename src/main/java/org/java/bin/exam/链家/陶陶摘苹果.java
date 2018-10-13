package org.java.bin.exam.链家;

/**
 * Created by wangbin on 2017/8/19.
 */
import java.util.*;
public class 陶陶摘苹果 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int[] apples = new int[10];
        for (int i = 0; i < 10; i++) {
            apples[i] = reader.nextInt();
        }
        int height = reader.nextInt();
        int res = 0;
        for (int i = 0; i < 10; i++) {
            if (apples[i] - 30 <= height) {
                res++;
            }
        }
        System.out.println(res);
    }
}
