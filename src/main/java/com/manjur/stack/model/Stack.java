package com.manjur.stack.model;

public class Stack {

    private Node top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public void push(int value) {

        Node temporary = new Node();

        if (temporary == null) {
            System.out.println("\nOut of memory");
            return;
        }

        temporary.data = value;
        temporary.next = top;
        top = temporary;

        size++;
    }

    public int pop() {
        if (top == null) {
            System.out.println("\nStack is empty");
            return -1;
        }
        int value = top.data;
        top = top.next;
        size--;
        return value;
    }

    public int peek() {
        if (!isEmpty()) {
            return top.data;
        }
        System.out.println("\nStack is empty");
        return -1;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return this.size;
    }
}

class Node {
    int data;
    Node next;
}