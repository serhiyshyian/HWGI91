package com.goit.myproject;

import java.util.LinkedList;

public class MyQueue<T> {
    private LinkedList<T> list;

    public MyQueue() {
        list = new LinkedList<>();
    }

    public void add(T value) {
        list.addLast(value);
    }

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public T peek() {
        return list.peekFirst();
    }

    public T poll() {
        return list.pollFirst();
    }
}
