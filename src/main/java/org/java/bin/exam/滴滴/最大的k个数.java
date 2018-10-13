package org.java.bin.exam.滴滴;

/**
 * Created by wangbin on 2017/8/26.
 */
import java.util.*;

public class 最大的k个数 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String str = reader.nextLine();
        int k = reader.nextInt();
        String[] numStr = str.split(" ");
        int n = numStr.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(numStr[i]);
        }

        quickSort(arr);
        System.out.println(arr[k - 1]);

    }

    public static void quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    private static void qSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            qSort(arr, low, pivot - 1);
            qSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        chosePivot(arr, low, high);
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] <= pivot) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[low] >= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }

        arr[low] = pivot;
        return low;
    }

    private static void chosePivot(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (a[low] > a[high]) {
            swap(a, low, high);
        }
        if (a[mid] > a[high]) {
            swap(a, mid, high);
        }
        if (a[mid] > a[low]) {
            swap(a, low, mid);
        }
    }

    private static void swap(int[] a, int low, int high) {
        int temp = a[low];
        a[low] = a[high];
        a[high] = temp;
    }
}
