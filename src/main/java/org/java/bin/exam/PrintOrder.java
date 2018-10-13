package org.java.bin.exam;

import java.util.Arrays;

/**
 * Created by wangbin on 2017/8/13.
 */
public class PrintOrder {
    public static void main(String[] args) {
        PrintOrder printOrder = new PrintOrder();
        int[] n = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        printOrder.printOrder(n, 3);
    }

    public void printOrder(int[] n, int m){
        if (n == null || n.length == 0 || n.length < m) {
            return;
        }
        int length = n.length;
        int start = 0;
        int index = 0;
        while (length > 0) {
            index = start + m;
            if (index >= length) {
                index -= length;
            }
            System.out.println( "n.length = " + n.length + "; index = " + index + " ;content = " + n[index]);
            int[] newArray = new int[length - 1];
            if (index != length - 1) {
                System.arraycopy(n, index, n, index + 1, length - index - 1);
                System.arraycopy(n, 0, newArray, 0, length - 1);
            } else {
                System.arraycopy(n,0,newArray,0,length - 1);
            }
            start = index;
            length--;
            n = newArray;
        }
    }
}
