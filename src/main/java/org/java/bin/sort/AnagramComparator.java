package org.java.bin.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.locks.Lock;

/**
 * Created by wangbin on 16/12/21.
 */
public class AnagramComparator implements Comparator<String> {
    public String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    @Override
    public int compare(String o1, String o2) {
        return sortChars(o1).compareTo(sortChars(o2));
    }

}
