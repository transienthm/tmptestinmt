package org.java.bin.datastructure.sort;

import java.util.Random;

/**
 * Created by wangbin on 2017/8/16.
 */
public class QuickSort implements Sort {
    @Override
    public void sort(Comparable[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        try {
            qSort(a, 0, a.length - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sort3Ways(Comparable[] a, int low, int high) {
        if (high - low <= 0) {
            return;
        }
        Comparable v = a[low];

        int lt = low;
        int gt = high + 1;
        int i = low + 1;
        while (i < gt) {
            if (a[i].compareTo(v) < 0) {
                swap(a, i, lt + 1);
                lt++;
                i++;
            } else if (a[i].compareTo(v) > 0) {
                swap(a, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }

        swap (a, low, lt);
        sort3Ways(a, low, lt - 1);
        sort3Ways(a, gt, high);
    }

    public void qSort(Comparable[] a, int low, int high) throws Exception{
        while (low < high) {
            int pivot = partition(a, low, high);
            qSort(a, low, pivot - 1);
            low = pivot + 1;
        }
    }

    public int partition(Comparable[] a, int low, int high) {
        Comparable pivotVal = chosePivot(a, low, high);
        while (low < high) {
           while (low < high && a[high].compareTo(pivotVal) >= 0) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low].compareTo(pivotVal) <= 0) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = pivotVal;
        return low;
    }

    public Comparable chosePivot(Comparable[] a, int low, int high) {
        int mid = (low + high) >> 1;
        if (a[low].compareTo(a[high]) < 0) {
            swap(a, low, high);
        }
        if (a[mid].compareTo(a[high]) < 0) {
            swap(a, mid, high);
        }
        if(a[mid].compareTo(a[low]) < 0) {
            swap(a, low, mid);
        }
        return a[low];
    }

    public void swap(Comparable[] a, int low, int high) {
        if (a == null || a.length <= low || a.length <= high) {
            return;
        }

        Comparable temp = a[low];
        a[high] = a[low];
        a[low] = temp;
    }
    public void quickSort3Ways(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        long seed = System.nanoTime();
        Random random = new Random(seed);

        int pos = random.nextInt(high - low + 1) + low;
        swap(arr, low, pos);

        int v = arr[low];

        int lt = low; //arr[low+1...lt] < v 初始区间为空
        int gt = high + 1;// arr[gt...high] > v 初始区间为空
        int i = low + 1; // arr[lt+1...i] = v 初始区间为空

        while (i < gt) {
            if (arr[i] > v) {
                swap(arr, i, gt - 1);
                gt--;
            } else if (arr[i] < v) {
                swap(arr, lt + 1, i);
                lt++;
                i++;
            } else {
                i++;
            }
        }

        swap(arr, lt, low);
        quickSort3Ways(arr, low, lt - 1);
        quickSort3Ways(arr, gt, high);
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Comparable[] a = SortTestHelper.getRandom(1000000, 0, 1000);
        QuickSort quickSort = new QuickSort();
        Comparable[] ano = SortTestHelper.copyArray(a);
        SortTestHelper.runTime("快速排序", quickSort, a);
        int[] ano1 = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            ano1[i] = (Integer) a[i];
        }
        long start = System.currentTimeMillis();
//        quickSort.sort3Ways(ano, 0, ano.length - 1);
        quickSort.quickSort3Ways(ano1, 0, ano.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("3Ways = " + (end - start) + "ms");
        System.out.println(SortTestHelper.isSorted(a));
        System.out.println(SortTestHelper.isSorted(ano1));
    }
}
