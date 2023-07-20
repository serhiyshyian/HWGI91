package com.goit.myproject;

import java.util.ArrayList;

public class MyStack<T> {
    private ArrayList<T> list;

    public MyStack() {
        list = new ArrayList<>();
    }

    public void push(T value) {
        list.add(value);
    }

    public void remove(int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public T peek() {
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(list.size() - 1);
        }
    }

    public T pop() {
        if (list.isEmpty()) {
            return null;
        } else {
            return list.remove(list.size() - 1);
        }
    }
}

