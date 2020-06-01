package com.ajaymourya;

public class CircularSinglyLinkedList {

    Node head;
    Node tail;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void prepend(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
            return;
        }
        newNode.next = head;
        tail.next = newNode;
        head = newNode;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
            return;
        }
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    public void insertAfter(int prevData, int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == prevData && tail.data == prevData){
            Node newNode = new Node(data);
            newNode.next = head.next;
            head.next = newNode;
            tail = newNode;
            return;
        }
        Node current = head;
        while (current.next != tail) {
            if (current.data == prevData) {
                Node newNode = new Node(data);
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        }
        if (current.next.data == prevData) {
            Node newNode = new Node(data);
            newNode.next = current.next.next;
            current.next.next = newNode;
            tail = newNode;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != tail) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.print(current.data);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList cll = new CircularSinglyLinkedList();
        cll.prepend(8);
        cll.prepend(7);
        cll.prepend(6);
        cll.display();
        cll.append(10);
        cll.prepend(5);
        cll.display();
        cll.insertAfter(5, 12);
        cll.insertAfter(10, 2);
        cll.display();
        cll.insertAfter(7, 44);
        cll.display();
    }

}
