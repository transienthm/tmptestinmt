package org.java.bin.demo;

/**
 * Created by wangbin on 2017/6/23.
 */
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
public class Solution {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        int length = sequence.length;
        int root = sequence[length - 1];
        int i = 0;
        for(; i < length - 1; i++){
            if(sequence[i] > root){
                break;
            }
        }

        "abc".toCharArray();
        int j = i;
        for(; j < length - 1; j++){
            if(sequence[j] < root){
                return false;
            }
        }

        boolean left = true;
        int leftLen = 0;
        int rightLen = 0;
        if(i > 0){
            leftLen = i;
            int[] leftArr = new int[leftLen];
            System.arraycopy(sequence, 0, leftArr, 0, leftLen);
            System.out.println("leftArr = " + leftArr[0] + " i = " + i);
            left = VerifySquenceOfBST(leftArr);
        }
        boolean right = true;
        if(i < length - 1){
            rightLen = length - leftLen - 1;
            int[] rightArr = new int[rightLen];
            System.arraycopy(sequence, i, rightArr, 0, rightLen);
            right = VerifySquenceOfBST(rightArr);
        }

        return left && right;
    }

    public static void main(String[] args) {
        //[1,2,3,4,5],[4,3,5,1,2]
        int[] a = new int[]{4,8,6,12,16,14,10};
        //int[] b = new int[]{4,5,3,2,1};
        System.out.println(VerifySquenceOfBST(a));
    }
}
