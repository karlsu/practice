package com.example;

/**
 * Created by suwantao on 17/5/26.
 */

public class Node {
    //数据域
    int data;
    //指针域
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;

    }

    public void setNext(Node node) {
        this.next = node;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

}
