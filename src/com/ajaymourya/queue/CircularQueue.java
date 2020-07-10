package com.ajaymourya.queue;

public class CircularQueue {

    int[] items;
    int size, front, rear;

    CircularQueue(int size) {
        items = new int[size];
        this.size = size;
        front = -1;
        rear = -1;
    }

    boolean isFull() {
        if (front == 0 && rear == size - 1)
            return true;
        if (front == rear + 1)
            return true;
        return false;
    }

    boolean isEmpty() {
        if (front == -1)
            return true;
        return false;
    }

    void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % size;
            items[rear] = element;
            System.out.println("Inserted -> " + element);
        }
    }

    int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int element = items[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else
                front = (front + 1) % size;
            System.out.println("Deleted -> " + element);
            return element;
        }
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            int i;
            System.out.println("Front index position -> " + front);
            System.out.println("Rear index position -> " + rear);
            System.out.print("Items -> ");
            for (i = front; i != rear; i = (i + 1) % size) {
                System.out.print(items[i] + " ");
            }
            System.out.print(items[i] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.display();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.display();
        queue.deQueue();
        queue.deQueue();
        queue.display();
        queue.enQueue(6);
        queue.enQueue(7);
        queue.display();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.display();
    }
}
