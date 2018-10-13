package org.java.bin.datastructure.sort;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by wangbin on 2017/8/15.
 */
public class SortTestHelper {
    public static Integer[] getRandom(int n, int rangeL, int rangeR) {
        Random random = new Random(System.currentTimeMillis());
        Integer[] res = new Integer[n];
        for (int i = 0; i < n; i++) {
            res[i] = random.nextInt(rangeR - rangeL + 1) + rangeL;
        }
        return res;
    }

    public static void printArr(Integer[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean isSorted(Comparable[] a) {
        if (a == null || a.length == 0) {
            return false;
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1].compareTo(a[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSorted(int[] a) {
        if (a == null || a.length == 0) {
            return false;
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                return false;
            }
        }
        return true;
    }

    public static Comparable[] copyArray(Comparable[] a) {
        if (a == null || a.length == 0) {
            return new Comparable[0];
        }
        Comparable[] res = new Comparable[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = a[i];
        }
        return res;
    }

    public static void runTime(String sortName, Sort sort, Comparable[] a) {
        if (a == null || a.length == 0) {
            System.out.println("非法数组！");
            return;
        }
        System.out.println(sortName + "的运行效率为:");
        long start = System.currentTimeMillis();
        sort.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("运行时间为:" +(end - start) + " ms");
    }

    public static void main(String[] args) throws Exception {
        Integer[] a = SortTestHelper.getRandom(10000, 0, 1000000);
//        SelectSort selectSort = new SelectSort();
        InsertSort insertSort = new InsertSort();
        SortTestHelper.runTime("选择排序", insertSort, a);
//        SortTestHelper.printArr(a);
        System.out.println(SortTestHelper.isSorted(a));
    }
}
