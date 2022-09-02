package com.max.test;

public class DBLmain {
    public static void main(String[] args) {
        DBLlist<Integer> listy = new DBLlist<>();
        DBLlist<String> stringlist = new DBLlist<>();

        listy.addEnd(1);
        listy.addEnd(2);
        listy.addEnd(3);
        listy.addEnd(4);
        listy.deleteN(3);
        listy.print();
    }
}
