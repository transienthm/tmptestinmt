package org.java.bin.demo;

/**
 * Created by wangbin on 2017/6/25.
 */
public class Demo02 {
    public void revertStr(char[] chars){
        int length = chars.length;
        //翻转整个句子
        revertInPlace(chars, 0, length - 1);
        String str = new String(chars);
        String[] strs = str.split(" ");
        int wordCounts = strs.length;
        int[] eachLength = new int[wordCounts];
        int i = 0;
        for(String s : strs){
            eachLength[i++] = s.length();
        }
        int start = 0;
        for(int j = 0; j < wordCounts; j++){
            revertInPlace(chars, start, start + eachLength[j] - 1);
            start += eachLength[j] + 1;
        }
    }

    public void circularMove(char[] chars, int m){
        int n = chars.length;
        revertInPlace(chars, 0, m % n - 1);
        revertInPlace(chars, m % n, n - 1);
        revertInPlace(chars, 0, n - 1);
    }

    private void revertInPlace(char[] chars, int i, int j){
        while(i < j){
            swap(chars, i++, j--);
        }
    }
    private void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        Demo02 demo02 = new Demo02();
        String str = "abcd";
        char[] chars = str.toCharArray();

        demo02.circularMove(chars, 1);
        System.out.println(chars);
    }
}
