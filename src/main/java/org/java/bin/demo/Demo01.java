package org.java.bin.demo;

/**
 * Created by wangbin on 2017/6/17.
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println(19 / 2);
        int[] a = {0, 1};
        System.out.println(a[1]);

        String aStr = "hello world";
        changeString(aStr);
        System.out.println("in main:" + aStr);

        System.out.println("exchange=" + exchangeTimes("001011"));
    }

    public static void changeString(String a){
        a = "hello func";
        System.out.println("in func:" + a);
        char[] chars = new char[10];
        new String(chars);
    }

    public static int exchangeTimes(String s){
        int answer = 0;
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            for (; (i < j) && s.charAt(i) == '0'; i++) ;
            for (; (i < j) && s.charAt(j) == '1'; j--) ;
            if (i < j) {
                answer++;
            }
        }
        return answer;
    }

    //fibonacci
    public long fibonacci(int n){
        int[] result = {0, 1};
        if(n < 2){
            return result[n];
        }

        long fibNMinusOne = 1;
        long fibNMinusTwo = 0;
        long fibN = 0;
        for (int i = 2; i < n; i++) {
            fibN = fibNMinusOne + fibNMinusTwo;

            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }

        return fibN;
    }
}
