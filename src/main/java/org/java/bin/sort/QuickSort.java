package org.java.bin.sort;

import org.java.bin.datastructure.sort.SortTestHelper;

/**
 * Created by wangbin on 16/12/21.
 */
public class QuickSort {
    static final int MAX_LENGTH = 5;

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

    public static void quickSort01(int[] a) {
        qSort01(a, 0, a.length - 1);
    }

    private static void qSort01(int[] a, int low, int high) {
        if ((high - low) > MAX_LENGTH) {
            while (low < high) {
                int pivot = partition01(a, low, high);
                qSort(a, low, pivot - 1);
                low = pivot + 1;
            }
        }
    }

    private static int partition01(int[] a, int low, int high) {
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

    public static void div3DeScanSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = arr[low];

            int lt = low, gt = high + 1, i = low + 1;
            OUT_LOOP:
            while (i < gt) {
                System.out.println("i = " + i);
                if (arr[i] < pivot) {
                    swap(arr, i, lt + 1);
                    lt++;
                    i++;
                } else if (arr[i] == pivot) {
                    i++;
                } else {
                    while (arr[gt - 1] > pivot) {
                        gt--;
                        if (i > gt) {
                            break OUT_LOOP;
                        }
                    }

                    if (arr[gt - 1] < pivot) {
                        swap(arr, gt - 1, i);
                        swap(arr, lt + 1, i);
                        lt++;
                    } else {
                        swap(arr, gt - 1, i);
                    }
                    i++;
                    gt--;
                }
            }
            swap(arr, low, lt);
            div3DeScanSort(arr, low, lt - 1);
            div3DeScanSort(arr, gt, high);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.getRandom(10000, 0, 200);
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }

        div3DeScanSort(copy, 0, copy.length - 1);
        System.out.println(SortTestHelper.isSorted(copy));
    }
}
