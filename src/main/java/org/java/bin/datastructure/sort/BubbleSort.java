package org.java.bin.datastructure.sort;

/**
 * Created by wangbin on 2017/8/15.
 */
public class BubbleSort implements Sort {
    @Override
    public void sort(Comparable[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i + 1].compareTo(a[i]) < 0) {
                    Comparable temp = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = temp;
                    flag = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Comparable[] a = SortTestHelper.getRandom(1000, 0, 1000);
        BubbleSort sortor = new BubbleSort();
        sortor.sort(a);
        System.out.println(SortTestHelper.isSorted(a));
    }
}
