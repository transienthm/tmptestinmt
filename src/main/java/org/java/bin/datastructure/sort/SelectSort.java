package org.java.bin.datastructure.sort;

import java.lang.reflect.Method;

/**
 * Created by wangbin on 2017/8/15.
 */
public class SelectSort implements Sort {

    @Override
    public void sort(Comparable[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            SortTestHelper.swap(a, minIndex, i);
        }
    }
}
