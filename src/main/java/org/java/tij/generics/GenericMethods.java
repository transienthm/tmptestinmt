package org.java.tij.generics;

import java.util.*;

/**
 * Created by wangbin on 2017/9/21.
 */
public class GenericMethods {
    public <T extends List, E> void f(T x, E y, E z) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f(new ArrayList<>(), new HashMap<>(), new HashSet<>());
    }
}
