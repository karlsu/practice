package com.example;

/**
 * Created by suwantao on 17/5/27.
 */

public class Stack {

    public static void main(String args[]){
        Stack stack = new Stack();
        System.out.println("将0到10依次压栈");
        for(int i = 0;i < 10;i++)
            stack.push(i);
        System.out.println("连续执行5次出栈操作");
        for(int i = 0;i < 5;i++)
            stack.pop();
        System.out.println("栈为空吗？： " + stack.isEmpty());
        System.out.println("栈的大小为： " + stack.getSize());
        System.out.println("栈顶元素为： " + stack.head.getData());
        System.out.println("栈顶元素为： " + stack.peek());
    }


    //栈顶元素
    private Node head;
    //当前栈大小
    private int size;

    public Node getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public Stack() {
        this.head = null;
        size = 0;
    }

    private boolean isEmpty(){
        if (size==0) {
            return true;
        }
        return false;

    }
    private void isFull(){

    }
    private int peek(){
        int data = head.getData();
        return data;
    }

    private Node pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        Node node = head;
        head = head.getNext();
        node.setNext(null);
        size--;
        return node;
    }

    private Node push(int data) {
        Node node = new Node(data);
        node.setNext(head);
        head = node;
        size++;
        return head;
    }

}
