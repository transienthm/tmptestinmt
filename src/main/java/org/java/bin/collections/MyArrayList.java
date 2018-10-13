package org.java.bin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangbin on 2017/6/19.
 */

/**
 * 优点：get和set操作时间上都是O(1)
 * 缺点：add和remove操作时间上都是O(N)
 */
public class MyArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    Object[] elementData;
    private int size;

    //增加元素
    public boolean add(E e){
        ensureCapacity(size + 1);
        elementData[size++] = e;
        return true;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    E elementData(int index) {
        return (E) elementData[index];
    }

    public E remove(int index){
        rangeCheck(index);

        E oldValue = elementData(index);

        int numMoved = size - index - 1;
        if(numMoved > 0){
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }

        elementData[--size] = null;

        return oldValue;
    }

    public boolean remove(Object o){
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    fastRemove(i);
                    return true;
                }
            }
        }else{
            for (int i = 0; i < size; i++) {
                if (elementData[i].equals(o)) {
                    fastRemove(i);
                    return true;
                }
            }
        }
        return false;
    }

    private void fastRemove(int index){
        int numMoved = size - index - 1;

        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < elementData.length; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        }else{
            for (int i = 0; i < elementData.length; i++) {
                if (elementData[i].equals(o)) {
                    return i;
                }
            }
        }

        return -1;
    }

    //保证容量并扩容
    public void ensureCapacity(int minCapacity){
        minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);

        if(minCapacity - elementData.length > 0){
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0)
                newCapacity = minCapacity;
            if (newCapacity - MAX_ARRAY_SIZE > 0)
                newCapacity = hugeCapacity(minCapacity);
            // minCapacity is usually close to size, so this is a win:
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    private int hugeCapacity(int minCapacity){
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();

        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }
    public static void main(String[] args) {
        List list = new ArrayList();
    }
}
