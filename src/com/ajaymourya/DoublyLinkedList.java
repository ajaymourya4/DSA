package com.ajaymourya;

public class DoublyLinkedList {

    Node head;

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    public void prepend(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        Node newNode = new Node(data);
        current.next = newNode;
        newNode.prev = current;
    }

    public void insertAfter(int prevData, int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.data == prevData) {
                Node newNode = new Node(data);
                if (current.next != null)
                    current.next.prev = newNode;
                newNode.next = current.next;
                newNode.prev = current;
                current.next = newNode;
                return;
            }
            current = current.next;
        }
    }

    void delete(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
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
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.display();
        doublyLinkedList.prepend(2);
        doublyLinkedList.prepend(5);
        doublyLinkedList.display();
        doublyLinkedList.append(7);
        doublyLinkedList.append(10);
        doublyLinkedList.display();
        doublyLinkedList.insertAfter(7, 12);
        doublyLinkedList.display();
        doublyLinkedList.delete(7);
        doublyLinkedList.display();
    }
}
