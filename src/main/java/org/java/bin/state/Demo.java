package org.java.bin.state;

/**
 * Created by wangbin on 2017/1/28.
 */
public class Demo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        try {
            t.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
