package org.java.bin.exam.链家;

import java.util.*;

/**
 * Created by wangbin on 2017/8/21.
 */
public class 取数 {
    static List<List<Integer>> listAll = new ArrayList<>();
    static List<List<Integer>> checkedList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        int k = reader.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(Integer.MIN_VALUE);
        }
        getList(list, arr, m);
        checkList(listAll, k);
        int[] sumArr = getSumArr(checkedList);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < sumArr.length; i++) {
            if (sumArr[i] > max){
                max = sumArr[i];
            }
        }
        System.out.println(max);
    }

    public static void checkList(List<List<Integer>> listAll, int k) {
        boolean flag = true;
        for (List<Integer> list : listAll) {
            flag = true;
            for (int i = 0; i < list.size() - 1 && flag; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (Math.abs(list.get(i) - list.get(j)) <= k) {
                        flag = false;
                        continue;
                    }
                    if (i == list.size() - 2 && j == list.size() - 1){
                        checkedList.add(list);
                    }
                }
            }
        }
    }

    public static int[] getSumArr(List<List<Integer>> checkedList) {
        int size = checkedList.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            List<Integer> list = checkedList.get(i);
            res[i] = getSum(list);
        }
        return res;
    }

    public static int getSum(List<Integer> list) {
        int res = 0;
        for (int i : list) {
            res += i;
        }
        return res;
    }

    public static void getList(List<Integer> list, int[] arr, int m) {
        if (m == 0) {
            listAll.add(new ArrayList<>(list));
            return;
        }

        for (int i : arr) {
            if (!list.contains(i)) {
                list.set(list.size() - m, i);
            } else {
                continue;
            }
            getList(list, arr, m - 1);
            list.set(list.size() - m , Integer.MIN_VALUE);
        }
    }
}
