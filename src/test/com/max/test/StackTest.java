package com.max.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    void print() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.print();
        assertEquals("[5, 4, 3, 2, 1]", outputStreamCaptor.toString().trim());
    }

    @Test
    void push() {
        Stack stack = new Stack();
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());

        stack.push(9000);
        assertEquals(9000, stack.peek());
    }

    @Test
    void pop() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.pop();
        assertEquals(4, stack.size());
        assertEquals(4, stack.peek());

        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);

        stack.pop(8);
        assertEquals(2, stack.size());
        assertEquals(2, stack.peek());
        assertThrows(EmptyStackException.class, () -> stack.pop(3));
        stack.pop();
        stack.pop();
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    void size() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertEquals(5, stack.size());
    }

    @Test
    void peek() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.peek());
    }
}