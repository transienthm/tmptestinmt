package org.java.bin.thread;

/**
 * Created by wangbin on 16/12/21.
 */
public class SingletonDemo {

    private static SingletonDemo singletonDemo = null;

    private SingletonDemo() {
    }

    public static SingletonDemo getInstance() {
        if (singletonDemo == null) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            singletonDemo = new SingletonDemo();
        }
        return singletonDemo;
    }


    private static class SingletonHolder{
        private static final SingletonDemo INSTANCE = new SingletonDemo();
    }

    public static final SingletonDemo getSingletonDemo() {
        return SingletonHolder.INSTANCE;
    }
}
