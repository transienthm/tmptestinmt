package org.java.bin.datastructure.search;

import org.java.bin.datastructure.sort.SortTestHelper;

/**
 * Created by wangbin on 2017/8/18.
 */
public class BinarySearch {

    public int find(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (a[mid] < target) {
                l = mid + 1;
            } else if (a[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int find(int[] a, int target, int l, int r) {
        if (a == null || a.length == 0) {
            return -1;
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] < target) {
                find(a, target, mid + 1, r);
            } else if (a[mid] > target) {
                find(a, target, l, mid - 1);
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] a = SortTestHelper.getRandom(10, 0, 10);
        SortTestHelper.printArr(a);
        System.out.println();
        int[] arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = a[i];
        }
        System.out.println(new BinarySearch().find(arr, 4));
    }
}
