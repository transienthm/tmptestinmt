package org.java.bin.datastructure.sort;

/**
 * Created by wangbin on 2017/8/16.
 */
public class MergeSort implements Sort {
    @Override
    public void sort(Comparable[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        int high = a.length - 1;
        sort(a, 0, high);
    }

    public void sort(Comparable[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(a, low, mid);
            sort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    public void sortBU(Comparable[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        int n = a.length;
        for (int sz = 1; sz < n; sz += sz) {
            for (int i = 0; i < n - sz; i += 2 * sz) {
                merge(a, i, i + sz - 1, Math.min(i + 2* sz - 1, n - 1));
            }
        }
    }

    public void merge(Comparable[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        Comparable[] temp = new Comparable[high - low + 1];

        while (i <= mid && j <= high) {
            if (a[i].compareTo(a[j]) < 0) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= high) {
            temp[k++] = a[j++];
        }

        for (k = 0; k < temp.length; k++) {
            a[low + k] = temp[k];
        }
    }

    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();
        Comparable[] a = SortTestHelper.getRandom(1000, 0, 1000);
//        SortTestHelper.runTime("归并排序", sorter, a);
        System.out.println(SortTestHelper.isSorted(a));
        sorter.sortBU(a);
        System.out.println();
        System.out.println(SortTestHelper.isSorted(a));
    }
}
