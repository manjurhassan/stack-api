package com.manjur.stack.model;

public class Stack {

    private int[] arr;
    private int size;
    private int top;

    public Stack() {
        this.size = 100;
        this.arr = new int[100];
        this.top = -1;
    }

    public boolean push(int value) {

        if (top >= size - 1) {
            System.out.println("\nOut of memory");
            return false;
        }
        top = top + 1;
        arr[top] = value;

        return true;
    }

    public int pop() {
        if (top < 0) {
            System.out.println("\nStack is empty");
            return -1;
        }
        int value = arr[top];
        top = top - 1;

        return value;
    }

    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        }
        System.out.println("\nStack is empty");
        return -1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public int size() {
        return this.top + 1;
    }

    public boolean resize(int value) {
        if (value <= size) {
            System.out.println("\nInvalid size");
            return false;
        }
        int[] temp = new int[value];
        for (int i=0; i<=top; i++)
            temp[i] = arr[i];
        arr = temp;
        this.size = value;
        return true;
    }
}