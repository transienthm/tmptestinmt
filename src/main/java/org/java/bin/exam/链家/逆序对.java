package org.java.bin.exam.链家;

/**
 * Created by wangbin on 2017/8/21.
 */
public class 逆序对 {
    static int count = 0;

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

    public static void main(String ss[]) {

        // int data[] = { 8, 7, 5, 6, 4 };
        int data[] = { 4, 3, 2, 1 };
        mergeSort(data);

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
        System.out.println(count);
    }
}

