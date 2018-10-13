package org.java.bin.datastructure.heap;

import org.java.bin.datastructure.DataStructureHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by wangbin on 2017/8/17.
 */
public class MaxHeap<E extends Comparable> {
    private Comparable[] data;
    int count;

    public MaxHeap(int capacity) {
        data = new Comparable[capacity + 1];
        count = 0;
    }

    public MaxHeap(Comparable[] a) {
        int length = a.length;
        data = new Comparable[length + 1];

        for (int i = 0; i < length; i++) {
            data[i + 1] = a[i];
        }
        count = length;

        for (int i = count / 2; i>= 1; i--) {
            shiftDown(i);
        }
    }

    int size() {
        return count;
    }

    boolean isEmpty() {
        return count == 0;
    }

    public void insert(E item) {
        ensureCapacity(count + 1);
        data[++count] = item;
        shiftUp(count);
    }

    private void shiftUp(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            DataStructureHelper.swap(data, k / 2, k);
            k = k >> 1;
        }
    }

    private void ensureCapacity(int k) {
        if (k >= data.length) {
            int length = data.length * 2;
            Comparable[] newArr = new Comparable[length];
            System.arraycopy(data, 0, newArr, 0, data.length);
            data = newArr;
        }
    }

    public E extractMax() {
        if (count <= 0) {
            return null;
        }

        E res = (E) data[1];
        DataStructureHelper.swap(data, count--, 1);
        shiftDown(1);
        return res;
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) {
                j += 1;
            }
            if (data[k].compareTo(data[j]) > 0) {
                break;
            }
            DataStructureHelper.swap(data, k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        System.out.println(maxHeap.size());
    }
}
