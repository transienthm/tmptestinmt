package org.java.bin.reflection;

/**
 * Created by wangbin on 17/1/21.
 */
public class Demo01 {
    public static void main(String[] args) {
        String clazzName = "org.java.bin.reflection.bean.User";
        try {
            Class<?> clazz = Class.forName(clazzName);
            System.out.println(clazz);

        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
}
