package com.max.test;

public class DBLlist <T> {

    private DBLelement start;
    private DBLelement end;
    public int size = 0;

    public DBLlist() { start = null; }

    public int size() {
        return size;
    }

    public void addFront (T data) {
        if (start == null){
            start = new DBLelement(data);
            end = start;
        }
        else {
            DBLelement temp = new DBLelement(data);
            temp.setNext(start);
            start.setPrev(temp);
            start = temp;
        }
        size++;
    }

    public void addEnd (T data) {
        if (start == null){
            start = new DBLelement(data);
            end = start;
        }
        else {
            DBLelement temp = new DBLelement(data);
            temp.setPrev(end);
            end.setNext(temp);
            end = temp;
        }
        size++;
    }

    public void print () {
        if (start == null) {
            System.out.print("\nEmpty");
        } else {
            DBLelement pointer = start;
            System.out.print("\n[");
            while (pointer != null) {
                System.out.print(pointer.getData());
                if(pointer.getNext() != null) {
                    System.out.print(", ");
                }
                pointer = pointer.getNext();
            }
            System.out.print("]");
        }
    }

    public void printReverse () {
        DBLelement pointer = end;
        System.out.print("\n[");
        while (pointer != null) {
            System.out.print(pointer.getData());
            if(pointer.getPrev() != null) {
                System.out.print(", ");
            }
            pointer = pointer.getPrev();
        }
        System.out.print("]");
    }

    public void seek (T search) {
        boolean found = false;
        int position = 1;
        DBLelement pointer = start;
        while (pointer != null) {
            if (pointer.getData().equals(search)){
                System.out.println("\nResult for " + search + " found at position: " + position);
                found = true;
            }
            pointer = pointer.getNext();
            position++;
        }
        if (!found) {
            System.out.println("\nSadly no Results where found for " + search);
        }
    }

    public void seekReverse (T search) {
        boolean found = false;
        int position = size;
        DBLelement pointer = end;
        while (pointer != null) {
            if (pointer.getData().equals(search)){
                System.out.println("\nResult for " + search + " found at position: " + position);
                found = true;
            }
            pointer = pointer.getPrev();
            position--;
        }
        if (!found) {
            System.out.println("\nSadly no Results where found for " + search);
        }
    }

    public void delete (T delete) {
        boolean found = false;
        DBLelement pointer = start;
        while (pointer != null) {
            if (pointer.getData().equals(delete)){
                if (pointer.equals(start)) {
                    start = start.getNext();
                    start.setPrev(null);
                    pointer.setNext(null);
                }
                else if (pointer.equals(end)) {
                    end = end.getPrev();
                    end.setNext(null);
                    pointer.setPrev(null);
                }
                else {
                    pointer.getPrev().setNext(pointer.getNext());
                    pointer.getNext().setPrev(pointer.getPrev());
                }
                System.out.print("\n" + pointer.getData() + " deleted");
                found = true;
                size--;
            }
            pointer = pointer.getNext();
        }
        if (!found) {
            System.out.print("\nSadly no Results where found for " + delete);
        }
    }

    public void deletelast() {
        if (start == null) { return; }
        if (start.getNext() == null) {
            start = null;
            end = null;
        } else {
            end = end.getPrev();
            end.setNext(null);
        }
        size--;

    }

    public void deletefirst() {
        if (start == null) { return; }
        if (start.getNext() == null) {
            start = null;
            end = null;
        } else {
            start = start.getNext();
            start.setPrev(null);
        }
        size--;
    }

    public T seeklast() {
        if (start != null) {
            return (T)end.getData();
        } else return null;
    }

    public T seekstart() {
        if (start != null) {
            return (T)start.getData();
        } else return null;
    }

    public void deleteN(int amount) {
        StringBuilder deletesave = new StringBuilder();
        if (amount > size) {
            amount = size;
        }
        deletesave.append("\nDeleted: [");
        for (int i = 0; i < amount; i++){
            deletesave.append(seeklast());
            if(i+1 < amount){
                deletesave.append(", ");
            }
            deletelast();
        }
        deletesave.append("]");
        System.out.println(deletesave);
    }

    public void deleteNstart(int amount) {
        StringBuilder deletesave = new StringBuilder();
        if (amount > size) {
            amount = size;
        }
        deletesave.append("\nDeleted: [");
        for (int i = 0; i < amount; i++){
            deletesave.append(seekstart());
            if(i+1 < amount){
                deletesave.append(", ");
            }
            deletefirst();
        }
        deletesave.append("]");
        System.out.println(deletesave);
    }
}