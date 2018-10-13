package org.java.bin.thread;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Created by wangbin on 2018/10/7.
 */
public class BoundedHashSet<T> {
    private final Set<T> set;
    private final Semaphore sem;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        this.sem = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {
        sem.acquire();
        System.out.println("before add..." + sem.getQueueLength());
        boolean wasAdded = false;

        try {
            wasAdded = set.add(o);
            return wasAdded;
        } finally {
//            if (!wasAdded) {
                System.out.println("finally....");
                System.out.println("before release..." + sem.getQueueLength());
                sem.release();
                System.out.println("after release..." + sem.getQueueLength());
//            }
        }
    }

    public static void main(String[] args) {
        BoundedHashSet<Integer> set = new BoundedHashSet<>(5);
        for (int i = 0; i < 10; i++) {
            try {
                set.add(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
