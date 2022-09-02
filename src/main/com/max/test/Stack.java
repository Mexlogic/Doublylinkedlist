package com.max.test;

import java.util.EmptyStackException;

public class Stack {
    private final DBLlist<Integer> list = new DBLlist<>();

    public Stack(){
    }

    public void print(){
        list.print();
    }

    public void push(int data){
        list.addFront(data);
    }

    public void pop(int amount){
        if ((list.size - amount) < 0) {
            throw new EmptyStackException();
        } else list.deleteNstart(amount);
    }

    public void pop(){
        if (list.size >= 1) {
            System.out.print("\nDeleted: "+list.seekstart());
            list.deletefirst();
        } else throw new EmptyStackException();
    }

    public int size(){
        return list.size;
    }

    public Integer peek(){
        return list.seekstart();
    }

}