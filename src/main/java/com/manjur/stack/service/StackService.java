package com.manjur.stack.service;

import com.manjur.stack.model.Stack;
import org.springframework.stereotype.Service;

@Service
public class StackService {

    private Stack stack;

    public StackService() {
        this.stack = new Stack();
    }

    public boolean pushValue(int data) {
        return this.stack.push(data);
    }

    public int popValue() {
        return this.stack.pop();
    }

    public int peek() {
        return this.stack.peek();
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public int size() {
        return this.stack.size();
    }

    public boolean resizeStack(int value) {
        return this.stack.resize(value);
    }
}
