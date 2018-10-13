package org.java.bin.demo;

/**
 * Created by wangbin on 2017/7/9.
 */

import java.util.Stack;

public class Demo03 {
    public static void main(String[] args) {
        System.out.println(new Demo03().isValid("([)]"));

    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char cur = stack.pop();
                System.out.println("cur = " + cur);
                if (cur == '(') {
                    if (c != ')') {
                        return false;
                    }
                }
                if (cur == '[') {
                    if (c != ']') {
                        return false;
                    }
                }
                if (cur == '{') {
                    if (c != '}') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
