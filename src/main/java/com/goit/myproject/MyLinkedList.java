package com.goit.myproject;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;

        public Node(T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    public void remove(int index) {
        if (index >= 0 && index < size) {
            Node<T> currentNode = getNodeAtIndex(index);

            if (currentNode == head) {
                head = currentNode.next;
                if (head != null) {
                    head.prev = null;
                }
            } else if (currentNode == tail) {
                tail = currentNode.prev;
                tail.next = null;
            } else {
                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;
            }

            size--;
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            Node<T> currentNode = getNodeAtIndex(index);
            return currentNode.value;
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    private Node<T> getNodeAtIndex(int index) {
        Node<T> currentNode;
        if (index <= size / 2) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }
}

