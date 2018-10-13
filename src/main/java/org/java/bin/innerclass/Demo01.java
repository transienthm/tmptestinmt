package org.java.bin.innerclass;

/**
 * Created by wangbin on 2017/1/24.
 */
public class Demo01 {
    public static void main(String[] args) {
        Outer out = new Outer();
        Outer.Inner ic = out.new Inner();
        ic.print();
    }
}

class Outer {

    private int a = 3;

    /**
     * 成员内部类
     * 不能有静态成员
     * 不能有静态方法
     */
    class Inner{

        void print() {
            System.out.println("a = " + a);
            System.out.println("内部类对象：" + this);
            System.out.println("外部类对象：" + Outer.this);
        }
    }

    /**
     * 方法内部类
     */
    public void test() {
        int b = 0;

        class Inner02 {
            public void print() {
                System.out.println(b);
            }
        }

    }
}
