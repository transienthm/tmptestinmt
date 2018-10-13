package org.java.bin.sort;

/**
 * Created by wangbin on 16/12/21.
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    flag = true;
                }
            }
        }
    }

    public static void bubbleSort0(int[] a){
        int len = a.length;

        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if (a[j - 1] > a[j]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }
}
