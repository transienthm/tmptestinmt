package org.java.bin.demo;

import java.util.Stack;
/**
 * Created by wangbin on 2017/6/23.
 */
public class MinStack {

    Stack<Integer> s1;
    Stack<Integer> s2;
    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
        if(s2.isEmpty() || s2.peek() >= x){
            s2.push(x);
        }
    }

    public void pop() {
        if(s1.peek() == getMin()){
            s2.pop();
        }
        s1.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        if(s2.isEmpty()){
            return Integer.MAX_VALUE;
        }
        return s2.peek();
    }

    @Override
    public String toString() {
        return "MinStack{" +
                "s1=" + s1 +
                ", s2=" + s2 +
                '}';
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        System.out.println("push:" + minStack);

        minStack.push(-1024);
        System.out.println("push:" + minStack);

        minStack.push(-1024);
        System.out.println("push:" + minStack);

        minStack.push(512);
        System.out.println("push:" + minStack);

        minStack.pop();
        System.out.println("pop:" + minStack);

        minStack.getMin();
        System.out.println("getMin:" + minStack);

        minStack.pop();
        System.out.println("pop:" + minStack);

        minStack.getMin();
        System.out.println("getMin:" + minStack);

        minStack.pop();
        System.out.println("pop:" + minStack);

        minStack.getMin();
        System.out.println("getMin:" + minStack);
    }
}

