package org.java.bin.exam.链家;

import java.io.*;
import java.util.*;

/**
 * Created by wangbin on 2017/8/19.
 */
public class 小明做调查 {
    public static void main(String[] args) {
        File file = new File("/Users/wangbin/Desktop/random.in");
        Scanner reader = null;
        int length = 0;
        int[] nums = null;
        try {
            reader = new Scanner(file);
            length = reader.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (reader != null) {
            nums = new int[length];
            for (int i = 0; i < length; i++) {
                nums[i] = reader.nextInt();
            }
            nums = setToArr(arrToSet(nums));
            quickSort(nums);
        }

        int outLen = nums.length;
        FileWriter out = null;
        try {
            out = new FileWriter(new File("/Users/wangbin/Desktop/random.out"));
            out.write(outLen + "\r\n");
            for (int i = 0; i < outLen; i++) {
                out.write(nums[i] + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    private static void qSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            qSort(arr, low, pivot - 1);
            qSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }

        arr[low] = pivot;
        return low;
    }

    public static Set<Integer> arrToSet(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new HashSet<>();
        }
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        return set;
    }

    public static int[] setToArr(Set<Integer> set) {
        if (set == null) {
            return new int[0];
        }

        int length = set.size();
        int[] res = new int[length];
        Iterator<Integer> iter = set.iterator();
        int i = 0;
        while (iter.hasNext()) {
            res[i++] = iter.next();
        }
        return res;
    }
}
