package org.java.bin.thread;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangbin on 2017/10/15.
 */
public class ThreadPool {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("1->2->5");
        int index = sb.lastIndexOf("->");
        System.out.println(index);
        sb.delete(index, sb.length());
        System.out.println(sb.toString());
    }
}
