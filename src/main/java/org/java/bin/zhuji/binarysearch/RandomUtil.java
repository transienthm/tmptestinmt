package org.java.bin.zhuji.binarysearch;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 描述:
 *
 * @author Alcalde
 * @create 2018-09-18 下午10:00
 */
public class RandomUtil {
    public static int[] getRandomArray(int n) {
        if (n <= 0) {
            return new int[0];
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int random = ThreadLocalRandom.current().nextInt(0, 500);
            arr[i] = random;
        }

        return arr;
    }

    public static int[] generateRandom() {
        return null;
    }

    public static void main(String[] args) {
        int[] id = new int[1];
        id[0]++;
        System.out.println(id[0]);
        id[0] = 10;
        System.out.println(id[0]);
        id[0]++;
        System.out.println(id[0]);
    }
}
