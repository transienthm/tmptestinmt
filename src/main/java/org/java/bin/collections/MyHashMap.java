package org.java.bin.collections;

import java.util.*;

/**
 * Created by wangbin on 2017/6/19.
 */
public class MyHashMap {
    public static void main(String[] args) {
        Map map = new HashMap();
        Queue q = new ArrayDeque();
        Stack s = new Stack();
    }

    boolean isPossible(int[] in, int[] out){

        Stack<Integer> s = new Stack<>();
        for (int i = 0, j = 0; j < out.length; j++) {

            while (s.empty() || s.peek() != out[j]) {
                if (i >= in.length) {
                    return false;
                }
                s.push(in[i++]);
            }
            s.pop();
        }
        return true;
    }
}
