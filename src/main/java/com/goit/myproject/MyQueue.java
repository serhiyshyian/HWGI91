package com.goit.myproject;

public class MyQueue {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
            this.next = null;
        }
    }

    public MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(Object value) {
        Node newNode = new Node(value);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (head != null) {
            return head.value;
        } else {
            return null;
        }
    }

    public Object poll() {
        if (head != null) {
            Node firstNode = head;
            head = head.next;
            size--;

            if (head == null) {
                tail = null;
            }

            return firstNode.value;
        } else {
            return null;
        }
    }
}
