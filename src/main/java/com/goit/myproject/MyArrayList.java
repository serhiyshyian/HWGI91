package com.goit.myproject;

import java.util.Arrays;

public class MyArrayList {
    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[10];
        size = 0;
    }

    public void add(Object value) {

        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }

        array[size] = value;
        size++;
    }

    public void remove(int index) {
        if (index >= 0 && index < size) {

            System.arraycopy(array, index + 1, array, index, size - index - 1);
            array[size - 1] = null;
            size--;
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public void clear() {

        Arrays.fill(array, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index >= 0 && index < size) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }
}
