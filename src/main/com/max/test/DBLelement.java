package com.max.test;

public class DBLelement <T> {
    private DBLelement next;
    private DBLelement prev;
    private T data;

    public DBLelement(T data){
        next = null;
        prev = null;
        this.data = data;
    }

    public DBLelement getPrev() {
        return prev;
    }

    public void setPrev(DBLelement prev) {
        this.prev = prev;
    }

    public DBLelement getNext() {
        return next;
    }

    public void setNext(DBLelement next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
