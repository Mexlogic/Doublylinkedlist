package com.max.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    Queue queue;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        queue = new Queue();
    }
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    void print() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.print();
        assertEquals("[1, 2, 3, 4, 5, 6]", outputStreamCaptor.toString().trim());
    }

    @Test
    void enqueue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        assertEquals(6, queue.size());
        queue.dequeue();
        assertEquals(5, queue.size());
    }

    @Test
    void size() {
        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        assertEquals(4, queue.size());

        queue.dequeue(2);

        assertEquals(2, queue.size());
    }

    @Test
    void dequeue() {
        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);

        assertThrows(QueueTooSmallException.class, () -> queue.dequeue(11));

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        assertEquals(1, queue.size());

        queue.dequeue();

        assertThrows(QueueTooSmallException.class, queue::dequeue);
    }
}