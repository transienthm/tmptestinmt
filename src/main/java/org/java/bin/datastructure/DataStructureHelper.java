package org.java.bin.datastructure;

/**
 * Created by wangbin on 2017/8/17.
 */
public class DataStructureHelper {
    public static void swap(Object[] a, int i, int j) {
        Object o = a[i];
        a[i] = a[j];
        a[j] = o;
    }

}
