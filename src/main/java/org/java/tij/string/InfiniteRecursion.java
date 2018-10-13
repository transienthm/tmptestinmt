package org.java.tij.string;

import java.util.*;
import static java.lang.System.out;
/**
 * Created by wangbin on 2017/9/21.
 */
public class InfiniteRecursion {
    @Override
    public String toString() {
        return "InfiniteRecursion address: " + super.toString() +"\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
        for (int i = 0; i < 10; i++) {
            v.add(new InfiniteRecursion());
        }
        out.println(new InfiniteRecursion());
    }
}
