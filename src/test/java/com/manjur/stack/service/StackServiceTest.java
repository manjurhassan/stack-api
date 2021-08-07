package com.manjur.stack.service;

import com.manjur.stack.model.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackServiceTest {

    @Test
    void pushValueSuccessTest() {
        StackService stackService = new StackService();
        stackService.pushValue(10);
        stackService.pushValue(15);
        assertEquals(2, stackService.size());
        assertEquals(15, stackService.peek());
        assertEquals(15, stackService.popValue());
        assertEquals(1, stackService.size());
        stackService.popValue();
        assertEquals(0, stackService.size());
        assertEquals(-1, stackService.popValue());
    }

    @Test
    void pushValueFailureTest() {
        StackService stackService = new StackService();
        for (int i=1; i<=100; i++) {
            stackService.pushValue(i);
        }
        assertEquals(100, stackService.size());
        assertEquals(false, stackService.pushValue(500));
    }

    @Test
    void popValueTest() {
        StackService stackService = new StackService();
        for (int i=1; i<=100; i++) {
            stackService.pushValue(i);
        }
        for (int i=100; i>=1; i--) {
            assertEquals(i, stackService.popValue());
        }
        assertEquals(0, stackService.size());
        assertTrue(stackService.isEmpty());
        assertEquals(-1, stackService.popValue());
        assertEquals(-1, stackService.peek());
    }

    @Test
    void peekTest() {
        StackService stackService = new StackService();
        for (int i=1; i<=100; i++) {
            stackService.pushValue(i);
            assertEquals(i, stackService.peek());
        }
        for (int i=100; i>=1; i--) {
            assertEquals(i, stackService.popValue());
        }
        assertEquals(-1, stackService.peek());
        assertTrue(stackService.isEmpty());
    }

    @Test
    void resizeStackTest() {
        StackService stackService = new StackService();
        for (int i=1; i<=100; i++) {
            stackService.pushValue(i);
        }
        assertEquals(100, stackService.size());
        assertFalse(stackService.resizeStack(90));
        assertEquals(100, stackService.size());
        assertFalse(stackService.resizeStack(100));
        assertEquals(100, stackService.size());
        assertTrue(stackService.resizeStack(110));
        for (int i=1; i<=10; i++) {
            stackService.pushValue(i);
        }
        assertEquals(110, stackService.size());
    }
}