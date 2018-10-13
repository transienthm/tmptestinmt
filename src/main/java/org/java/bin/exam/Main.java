package org.java.bin.exam;

/**
 * Created by wangbin on 2017/8/14.
 */
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[] b = new int[a];
        for (int i = 0; i < a; i++) {
            b[i] = scanner.nextInt();
        }
        Set<Integer> set = convertArrayToSet(b);
        b = convertSetToArray(set);
        Arrays.sort(b);
//        ArrayList arrayList = new ArrayList();
//        for (int i = 0; i < a; i++) {
//            if (!arrayList.contains(b[i])) {
//                arrayList.add(b[i]);
//            }
//        }
/*        if (arrayList.size() < 3)
            System.out.println(-1);
        else
            System.out.println(arrayList.get(2));*/
        if (b.length < 3){
            System.out.println(-1);
        } else {
            System.out.println(b[2]);
        }
    }
    public static Set<Integer> convertArrayToSet(int[] arr){
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < arr.length; i++){
            res.add(arr[i]);
        }
        return res;
    }

    public static int[] convertSetToArray(Set<Integer> set){
        Iterator<Integer> iter = set.iterator();
        int[] res = new int[set.size()];
        int i = 0;
        while (iter.hasNext()){
            res[i++] = iter.next();
        }
        return res;
    }
}
