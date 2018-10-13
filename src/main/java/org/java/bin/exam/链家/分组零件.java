package org.java.bin.exam.链家;

import java.util.*;
/**
 * Created by wangbin on 2017/8/21.
 */
public class 分组零件 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] ls = new int[n];
        int[] ws = new int[n];

        for (int i = 0; i < n; i++) {
            ls[i] = reader.nextInt();
            ws[i] = reader.nextInt();
        }

        Part[] parts = new Part[n];
        for (int i = 0; i < n; i++) {
            Part part = new Part(ls[i], ws[i]);
            parts[i] = part;
        }

        quickSort(parts);
        int[] unsortedWs = new int[n];
        for (int i = 0; i < n; i++) {
            Part part = parts[i];
            unsortedWs[i] = part.weight;
        }
        mergeSort(unsortedWs);
        System.out.println(count);
    }

    /**
     * 排序相关，快排三个方法
     */
    public static void quickSort(Part[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    private static void qSort(Part[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            qSort(arr, low, pivot - 1);
            qSort(arr, pivot + 1, high);
        }
    }

    private static int partition(Part[] arr, int low, int high) {
        Part pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high].compareTo(pivot) > 0) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[low].compareTo(pivot) <= 0) {
                low++;
            }
            arr[high] = arr[low];
        }

        arr[low] = pivot;
        return low;
    }

    /**
     * 求逆序对相关，利用归并排序的思想
     */
    static void mergearray(int a[], int first, int mid, int last, int temp[]) {
        int i = first, j = mid + 1;
        int m = mid, n = last;
        int k = 0;
        while (i <= m && j <= n) {
            if (a[i] > a[j]) {
                temp[k++] = a[j++];
                count += mid - i + 1;
            } else {
                temp[k++] = a[i++];
            }
        }
        while (i <= m) {
            temp[k++] = a[i++];
        }
        while (j <= n) {
            temp[k++] = a[j++];
        }
        for (i = 0; i < k; i++)
            a[first + i] = temp[i];
    }

    static void mergesort(int a[], int first, int last, int temp[]) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergesort(a, first, mid, temp);
            mergesort(a, mid + 1, last, temp);
            mergearray(a, first, mid, last, temp);
        }
    }

    static void mergeSort(int a[]) {
        int[] p = new int[a.length];
        mergesort(a, 0, a.length - 1, p);
    }
}

class Part implements Comparable{
    int length;
    int weight;

    @Override
    public int compareTo(Object o) {
        if (o instanceof Part) {
            o = (Part) o;
            return this.length - ((Part) o).length;
        } else {
            return 0;
        }

    }

    public Part(int length, int weight) {
        this.length = length;
        this.weight = weight;
    }
}
