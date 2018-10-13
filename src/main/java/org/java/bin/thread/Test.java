package org.java.bin.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by wangbin on 16/12/21.
 */
public class Test {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new SingletonThread());
        Thread thread2 = new Thread(new SingletonThread());
        thread1.start();
        thread2.start();
    }

}

class SingletonThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "创建了 -->" + SingletonDemo.getInstance());
    }
}
