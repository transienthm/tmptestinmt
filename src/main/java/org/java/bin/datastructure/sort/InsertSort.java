package org.java.bin.datastructure.sort;

/**
 * Created by wangbin on 2017/8/15.
 */
public class InsertSort implements Sort {
    @Override
    public void sort(Comparable[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            Comparable key = a[i];
            while (j >= 0 && a[j].compareTo(key) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

}
