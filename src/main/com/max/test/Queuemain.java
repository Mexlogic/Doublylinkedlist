package com.max.test;

public class Queuemain {
    public static void main(String[] args) throws QueueTooSmallException {
        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.print();
        System.out.println("SIZE: "+queue.size());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();


    }

}
