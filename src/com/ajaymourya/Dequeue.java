package com.ajaymourya;

public class Dequeue {

    int[] arr;
    int size;
    int front;
    int rear;

    Dequeue(int size) {
        arr = new int[size];
        this.size = size;
        front = -1;
        rear = 0;
    }

    boolean isFull() {
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }

    boolean isEmpty() {
        return front == -1;
    }

    void insertFront(int element) {
        if (isFull()) {
            System.out.println("Queue overflow");
        } else {
            if (front == -1) {
                front = 0;
                rear = 0;
            } else if (front == 0)
                front = size - 1;
            else front = front - 1;
            arr[front] = element;
        }
    }

    void insertRear(int element) {
        if (isFull()) {
            System.out.println("Queue overflow");
        } else {
            if (front == -1) {
                front = 0;
                rear = 0;
            } else if (rear == size - 1)
                rear = 0;
            else rear = rear + 1;
            arr[rear] = element;
        }
    }

    void deleteFront() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
        } else {
            if (front == rear) {
                front = -1;
                rear = -1;
            } else if (front == size - 1)
                front = 0;
            else front = front + 1;
        }
    }

    void deleteRear() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
        } else {
            if (front == rear) {
                front = -1;
                rear = -1;
            } else if (rear == 0)
                rear = size - 1;
            else rear = rear - 1;
        }
    }

    int getFront() {
        if (isEmpty()) {
            System.out.println(" Underflow");
            return -1;
        }
        return arr[front];
    }

    int getRear() {
        if (isEmpty() || rear < 0) {
            System.out.println(" Underflow\n");
            return -1;
        }
        return arr[rear];
    }

    void display() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Dequeue dequeue = new Dequeue(5);
        dequeue.insertFront(5);
        dequeue.insertFront(4);
        dequeue.display();
        System.out.println(dequeue.getFront());
        System.out.println(dequeue.getRear());
        dequeue.insertRear(2);
        dequeue.insertRear(1);
        dequeue.display();
        System.out.println(dequeue.getFront());
        System.out.println(dequeue.getRear());
        dequeue.deleteFront();
        dequeue.deleteRear();
        dequeue.display();
        System.out.println(dequeue.getFront());
        System.out.println(dequeue.getRear());
        dequeue.deleteFront();
        dequeue.deleteFront();
        dequeue.deleteFront();
    }
}
