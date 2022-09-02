package com.max.test;

public class Stackmain {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        stack.print();
        System.out.print("Size: " + stack.size());
        stack.pop();
        stack.print();
        System.out.print("Size: " + stack.size());
        stack.pop();
        stack.print();
        System.out.print("Size: " + stack.size());
        stack.pop();
        stack.print();
        System.out.print("Size: " + stack.size());
        stack.pop();
        stack.print();
        System.out.print("Size: " + stack.size());
        stack.pop();
        stack.print();
        System.out.print("Size: " + stack.size());
        stack.pop(1);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.print();
        System.out.println("Size: " + stack.size());

        stack.pop(4);
        stack.print();
        System.out.print(" Last: " + stack.peek());
        System.out.println(" Size: " + stack.size());
    }
}
