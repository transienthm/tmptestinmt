package org.java.bin.demo;

/**
 * Created by wangbin on 2017/8/1.
 */
import java.util.Scanner;

public class Main {
    static final int MAX_LENGTH = 10;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n < 3){
            throw new Exception("输入有误！");
        }
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            //得到输入
            array[i] = sc.nextInt();
        }
        //排序
        quickSort(array);
        //去0
        int[] res = removeZero(array);
        if(res.length < 3){
            System.out.println(0);
            return;
        }

        //找到非负下标
        int index = 0;
        for(; index < array.length; index++){
            if(array[index] >= 0){
                break;
            }
        }

        long cand1 = Integer.MIN_VALUE;
        long cand2 = Integer.MIN_VALUE;
        //如果有至少两个负数
        cand1 = array[0] * array[1] * array[n - 1];
        cand2 = array[n - 1] * array[n - 2] * array[n - 3];

        System.out.println("*****" + cand1 + "***" + cand2);
        System.out.println(Math.max(cand1, cand2));
    }

    public static int[] removeZero(int[] a){
        int zeroCount = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] == 0){
                zeroCount++;
            }
        }
        int newLen = a.length - zeroCount;
        int[] res = new int[newLen];
        for(int i = a.length - 1, j = newLen - 1; i >= 0 && j >= 0; i--){
            if(a[i] != 0){
                res[j] = a[i];
                j--;
            }
        }
        return res;
    }
    public static void quickSort(int[] a) {
        qSort(a, 0, a.length - 1);
    }

    private static void qSort(int[] a, int low, int high) {
        if ((high - low) > MAX_LENGTH) {
            while (low < high) {
                int pivot = partition(a, low, high);
                qSort(a, low, pivot - 1);
                low = pivot + 1;
            }
        } else {
            insertSort(a);
        }
    }

    private static int partition(int[] a, int low, int high) {
        chosePivot(a, low, high);
        int pivotValue = a[low];

        while (low < high) {
            while (low < high && a[high] > pivotValue) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] < pivotValue) {
                low++;
            }
            a[high] = a[low];
        }

        a[low] = pivotValue;
        return low;
    }

    private static void chosePivot(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (a[low] > a[high]) {
            swap(a, low, high);
        }
        if (a[mid] > a[high]) {
            swap(a, mid, high);
        }
        if (a[mid] > a[low]) {
            swap(a, low, mid);
        }
    }

    private static void swap(int[] a, int low, int high) {
        int temp = a[low];
        a[low] = a[high];
        a[high] = temp;
    }

    public static void insertSort(int[] a){
        for(int i = 1; i < a.length; i++){
            int key = a[i];
            int j = i - 1;
            for(; j >= 0 && a[j] > key; j--){
                a[j + 1] = a[j];
            }
            a[j + 1] = key;
        }
    }
}

