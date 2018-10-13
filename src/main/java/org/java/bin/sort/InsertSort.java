package org.java.bin.sort;

/**
 * Created by wangbin on 16/12/21.
 */
public class InsertSort {
/*    public static void insertSort(int[] arr) {
        int length = arr.length;
        int i;
        int j;
        int key;
        for (j = 1; j < length; j++) {
            key = arr[j];
            i = j - 1;
            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
    }*/

    public static void insertSort(int[] arr) {
        int length = arr.length;
        for (int j = 1; j < length; j++) {
            int key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
    }

    public static void insertSort01(int[] a){

        for(int i = 1; i < a.length; i++){

            int key = a[i];
            int j = i - 1;
            for(; j >= 0 && a[j] > key; j--){
                a[j + 1] = a[j];
            }
            a[j + 1] = key;
        }
    }
}
