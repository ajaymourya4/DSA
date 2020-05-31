package com.ajaymourya;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class LinkedList {

    Node head;

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(int data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void insertAfter(int prevData, int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == prevData) {
            Node newNode = new Node(data);
            newNode.next = head.next;
            head.next = newNode;
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.data == prevData) {
                Node newNode = new Node(data);
                newNode.next = current.next;
                current.next = newNode;
            }
            current = current.next;
        }
    }

    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current.next != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.print(current.data);
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.display();
        linkedList.append(5);
        linkedList.append(4);
        linkedList.append(2);
        linkedList.append(1);
        linkedList.display();
        linkedList.prepend(8);
        linkedList.prepend(7);
        linkedList.display();
        linkedList.delete(4);
        linkedList.display();
        linkedList.delete(7);
        linkedList.insertAfter(8, 10);
        linkedList.display();
        linkedList.append(14);
        linkedList.display();
        linkedList.prepend(12);
        linkedList.display();
    }
}
