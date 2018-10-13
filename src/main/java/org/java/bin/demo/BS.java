package org.java.bin.demo;

import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 *
 * @author Alcalde
 * @create 2018-09-14 下午10:52
 */
public class BS {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 5, 6, 7, 7, 7, 7};

        int i = binarySearchLast(arr, 5);
        System.out.println(i);
    }

    public static int binarySearchLast(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left < right) {

            mid = left + ((right - left + 1) >> 1);
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        if (arr[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    public static int binarySearchFirst(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (arr[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
}
