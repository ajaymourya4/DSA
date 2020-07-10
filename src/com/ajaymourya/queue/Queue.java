package com.ajaymourya.queue;

public class Queue {

    private int[] items;
    private int size, front, rear;

    Queue(int size) {
        items = new int[size];
        this.size = size;
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        if(front == 0 && rear == size - 1)
            return true;
        else
            return false;
    }

    public boolean isEmpty() {
        if(front == -1)
            return  true;
        else
            return false;
    }

    public void enQueue(int element) {
        if(isFull()) {
            System.out.println("Queue is full");
        } else {
            items[++rear] = element;
            if (front == -1)
                front = 0;
            System.out.println("Inserted -> " + element);
        }
    }

    public int deQueue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int element = items[front];
            if(front >= rear){
                front = -1;
                rear = -1;
            }else
                front++;
            System.out.println("Deleted -> " + element);
            return element;
        }
    }

    public void display() {
        if (isEmpty()){
            System.out.println("Queue is empty");
        } else {
            System.out.println("Front index position -> " + front);
            System.out.println("Rear index position -> " + rear);
            System.out.print("Items -> " );
            for (int i = front; i <= rear; i++) {
                System.out.print(items[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.display();
        queue.enQueue(2);
        queue.enQueue(1);
        queue.enQueue(5);
        queue.enQueue(4);
        queue.display();
        queue.deQueue();
        queue.deQueue();
        queue.display();
    }
}
