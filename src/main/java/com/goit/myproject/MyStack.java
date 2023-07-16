package com.goit.myproject;

public class MyStack {
    private Node top;
    private int size;

    private class Node {
        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
            this.next = null;
        }
    }

    public MyStack() {
        top = null;
        size = 0;
    }

    public void push(Object value) {
        Node newNode = new Node(value);

        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }

        size++;
    }

    public void remove(int index) {
        if (index >= 0 && index < size) {
            if (index == 0) {
                top = top.next;
            } else {
                Node currentNode = getNodeAtIndex(index);
                Node previousNode = getNodeAtIndex(index - 1);

                previousNode.next = currentNode.next;
            }

            size--;
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (top != null) {
            return top.value;
        } else {
            return null;
        }
    }

    public Object pop() {
        if (top != null) {
            Node poppedNode = top;
            top = top.next;
            size--;

            return poppedNode.value;
        } else {
            return null;
        }
    }

    private Node getNodeAtIndex(int index) {
        Node currentNode = top;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

}

