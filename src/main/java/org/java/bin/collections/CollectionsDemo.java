package org.java.bin.collections;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by wangbin on 16/12/30.
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        List<Integer> cards = new ArrayList<>();
        for (int i = 1; i < 53; i++) {
            cards.add(i);
        }
        Collections.shuffle(cards);

        List<Integer> p1 = new ArrayList<>();
        List<Integer> p2 = new ArrayList<>();
        List<Integer> p3 = new ArrayList<>();
        List<Integer> last = new ArrayList<>();

        for (int i = 0; i < 50; i += 3) {
            p1.add(cards.get(i));
            p2.add(cards.get(i + 1));
            p3.add(cards.get(i + 2));
        }

        last.add(cards.get(49));
        last.add(cards.get(50));
        last.add(cards.get(51));

        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("p3 = " + p3);
        System.out.println("last = " + last);
    }
}
