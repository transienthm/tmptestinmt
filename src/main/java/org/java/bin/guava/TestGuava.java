package org.java.bin.guava;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

/**
 * Created by wangbin on 16/12/14.
 */
public class TestGuava {
    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        List<String> list = Lists.newArrayList("moom", "son", "dad", "refer", "rencaiyi");
        Collection<String> palindromeList = Collections2.filter(list, new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return new StringBuilder(input).reverse().toString().equals(input);
            }
        });

        for (String temp : palindromeList) {
            System.out.println(temp);
        }
    }
}
