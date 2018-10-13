package org.java.bin.search;

/**
 * Created by wangbin on 2017/9/3.
 */
public class BinarySearch {
    public <T extends Comparable>T binarySearch(T[] a, T target) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low < high) {
            mid = low + ((high - low) >> 1);
            if (a[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else if (a[mid].compareTo(target) > 0) {
                high = mid - 1;
            } else {
                return a[mid];
            }
        }
        return null;
    }

    public <T extends Comparable> T binarySearchRec(T[] a, int low, int high, T target) {
        if (low > high) {
            return null;
        }

        int mid = low + ((high - low) >> 1);
        if (a[mid].compareTo(target) < 0) {
           return binarySearchRec(a, mid + 1, high, target);
        } else if (a[mid].compareTo(target) > 0) {
           return binarySearchRec(a, low, mid - 1, target);
        } else {
            return a[mid];
        }
    }
}
