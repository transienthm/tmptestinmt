package org.java.bin.test;

import com.google.common.collect.HashBasedTable;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * 描述:
 *
 * @author Alcalde
 * @create 2018-09-04 下午10:01
 */
public class Test01 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(null, "test");
        System.out.println(map.get(null));
        Hashtable hashtable = new Hashtable();
        hashtable.put(null, "test");
        System.out.println(hashtable.get(null));
    }
}
