package com.max.test;

public class Queue {
    private final DBLlist<Integer> queue = new DBLlist();

    public Queue() {}

    public void print() {
        queue.print();
    }

    public void enqueue(int in){
        queue.addEnd(in);
    }

    public int size(){
        return queue.size;
    }

    public void dequeue(){
        if (queue.size >= 1) {
            System.out.print("\nDeleted: " + queue.seekstart());
            queue.deletefirst();
        } else throw new QueueTooSmallException();
    }

    public void dequeue(int amount) {
        if ((queue.size - amount) < 0) {
            throw new QueueTooSmallException();
        } else queue.deleteNstart(amount);
    }
}
