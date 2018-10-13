package org.java.bin.sort;

/**
 * Created by wangbin on 16/12/21.
 */
public class ChooseSort {
/*    public static void chooseSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int lowIndex = i;

            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[lowIndex]) {
                    lowIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[lowIndex];
            arr[lowIndex] = temp;
        }
    }*/

    public static void chooseSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int lowIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[lowIndex]) {
                    lowIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[lowIndex];
            arr[lowIndex] = temp;
        }
    }
}
