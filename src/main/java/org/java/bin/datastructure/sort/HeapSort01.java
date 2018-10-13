package org.java.bin.datastructure.sort;

import org.java.bin.datastructure.heap.MaxHeap;

/**
 * Created by wangbin on 2017/8/17.
 */
public class HeapSort01 {
    public static void main(String[] args) {
        Comparable[] a = SortTestHelper.getRandom(10000000, 0, 100);
        Comparable[] ano = SortTestHelper.copyArray(a);
        Comparable[] a2 = SortTestHelper.copyArray(a);
        int length = a.length;
        long start = System.currentTimeMillis();
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(1000);
        for (int i = 0; i < a.length; i++) {
            maxHeap.insert(a[i]);
        }

        for (int i = a.length - 1; i >= 0; i--) {
            a[i] = maxHeap.extractMax();
        }
        long end = System.currentTimeMillis();
        System.out.println("堆排序用时 = " + (end - start) + "ms");
        MaxHeap<Comparable> maxHeap1 = new MaxHeap<Comparable>(a2);
        start = System.currentTimeMillis();
        for (int i = a.length - 1; i>= 0; i--) {
            a[i] = maxHeap1.extractMax();
        }
        end = System.currentTimeMillis();
        System.out.println("优化堆用时 = " + (end - start) + "ms");
        QuickSort quickSort = new QuickSort();
        start = System.currentTimeMillis();
        quickSort.sort3Ways(ano, 0, ano.length - 1);
        end= System.currentTimeMillis();
        System.out.println("快排用时 = " + (end - start) + "ms");
        System.out.println(SortTestHelper.isSorted(a));
        System.out.println(SortTestHelper.isSorted(ano));
    }
}
