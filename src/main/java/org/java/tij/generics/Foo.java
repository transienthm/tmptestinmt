package org.java.tij.generics;

/**
 * Created by wangbin on 2017/9/22.
 */
public class Foo<T> {
    T var;

    public static void main(String[] args) {
        Foo<Cat> foo = new Foo<>();
    }
}

class Cat{}
