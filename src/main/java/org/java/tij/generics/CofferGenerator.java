package org.java.tij.generics;

import java.util.*;

public class CofferGenerator implements Generator<Coffer>, Iterable<Coffer> {
    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};
    private static Random rand = new Random(47);

    public CofferGenerator() {
    }

    private int size = 0;

    public CofferGenerator(int size) {
        this.size = size;
    }

    @Override
    public Coffer next() {

        try {
            return (Coffer) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffer> {
        int count = size;
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffer next() {
            count--;
            return CofferGenerator.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    @Override
    public Iterator<Coffer> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CofferGenerator gen = new CofferGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
        for (Coffer c : new CofferGenerator(5)) {
            System.out.println(c);
        }
    }
}

class Coffer {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class Latte extends Coffer {}

class Mocha extends Coffer {}

class Cappuccino extends Coffer {
}

class Americano extends Coffer{}

class Breve extends Coffer{}
