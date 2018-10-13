package org.java.bin.exam;

/**
 * Created by wangbin on 2017/8/14.
 */
import java.util.Scanner;
public class 有趣的排序 {
    static int res = 0;
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        if (n <= 0) {
            return;
        }
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = reader.nextInt();
        }
        helper(a);
        System.out.println("res = " + res);
    }

    public static void helper(int[] a){
        if (a == null || a.length == 0 || a.length == 1) {
            return;
        }
        int length = a.length;
        int count = 0;
        int[] temp = new int[length];
        int j = 0;
        int max = a[0];
        for (int i = 1; i < a.length; i++){
            if (a[i - 1] > a[i]) {
                count++;
                temp[j++] = a[i - 1];
            }
            if(i == a.length - 1 && a[i] > max && count != 0){
               count++;
               temp[j++] = a[i];
            }
            max = Math.max(a[i - 1], a[i]);
        }
        res += count;
        int[] another = new int[count];
        System.arraycopy(temp, 0, another, 0, count);
        System.out.println();
        printArr(another);
        helper(another);
    }

    public static void printArr(int[] a){
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
