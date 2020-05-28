package com.ajaymourya;

public class Stack {

    private int[] arr;
    private int top;
    private int size;

    Stack(int size) {
        arr = new int[size];
        top = -1;
        this.size = size;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
        } else {
            System.out.println("Inserting " + x);
            arr[++top] = x;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return -1;
        } else
            return arr[top--];
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int getSize() {
        return top + 1;
    }

    public void printStack() {
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.pop();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.printStack();
        stack.pop();
        stack.printStack();
    }
}
