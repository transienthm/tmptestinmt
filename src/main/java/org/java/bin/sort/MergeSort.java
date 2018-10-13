package org.java.bin.sort;

/**
 * Created by wangbin on 16/12/21.
 */
public class MergeSort {
    public static void sort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int[] temp = new int[high - low + 1];
        int k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (k = 0; k < temp.length; k++) {
            arr[low + k] = temp[k];
        }
    }
}
