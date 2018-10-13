package org.java.bin.guava;


import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangbin on 16/12/31.
 */
public class MultiMapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("改革开放", "邓小平");
        map.put("三个代表", "江泽民");
        map.put("科学发展观", "胡锦涛");
        map.put("八荣八耻", "胡锦涛");

        Multimap<String, String> teachers = ArrayListMultimap.create();

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            teachers.put(value, key);
        }

        Set<String> keys = teachers.keySet();
        for (String str : keys) {
            System.out.println(str + " --> " + teachers.get(str));
        }

    }
}
