package com.ajaymourya.tree;

public class BinarySearchTree {
    BinarySearchTree left, right;
    int data;

    public BinarySearchTree(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null)
                left = new BinarySearchTree(value);
            else
                left.insert(value);
        } else {
            if (right == null)
                right = new BinarySearchTree(value);
            else
                right.insert(value);
        }
    }

    public boolean contains(int value) {
        if (value == data)
            return true;
        else if (value < data) {
            if (left == null)
                return false;
            else
                return left.contains(value);
        } else {
            if (right == null)
                return false;
            else
                return right.contains(value);
        }
    }

    public void printInOrder() {
        if (left != null)
            left.printInOrder();
        System.out.println(data);
        if (right != null)
            right.printInOrder();
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(5);
        bst.insert(2);
        bst.insert(8);
        bst.printInOrder();
        System.out.println("contains 8 " + bst.contains(8));
    }
}
