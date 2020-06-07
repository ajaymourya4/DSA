package com.ajaymourya;

public class CompleteBinaryTree {

    static class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }

    Node root;

    public int countNumNodes(Node node) {
        if (node == null)
            return 0;
        return (1 + countNumNodes(node.left) + countNumNodes(node.right));
    }

    public boolean checkComplete(Node root, int index, int numNodes) {
        if (root == null)
            return true;
        if (index >= numNodes)
            return false;
        return (checkComplete(root.left, 2 * index + 1, numNodes) && checkComplete(root.right, 2 * index + 2, numNodes));
    }

    public static void main(String[] args) {
        CompleteBinaryTree tree = new CompleteBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        int numNodes = tree.countNumNodes(tree.root);

        if (tree.checkComplete(tree.root, 0 , numNodes))
            System.out.print("The tree is a complete binary tree");
        else
            System.out.print("The tree is not a complete binary tree");
    }
}
