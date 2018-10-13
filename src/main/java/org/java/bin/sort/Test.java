package org.java.bin.sort;

import java.util.HashMap;

/**
 * Created by wangbin on 16/12/21.
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 34, 53, 21, 19, 66, 3, 7, 4, 16, 74, 72, 29, 31, 11, 46};
//        QuickSort.quickSort(arr);
//        BubbleSort.bubbleSort0(arr);

//        QuickSort.quickSort(arr);
        QuickSort.quickSort01(arr);
//        BubbleSort.bubbleSort(arr);
//        ChooseSort.chooseSort(arr);
//        InsertSort.insertSort01(arr);
//        MergeSort.sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" " + arr[i]);
        }
    }
}
