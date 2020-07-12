package com.ajaymourya.tree;

public class PerfectBinaryTree {

    static class Node {
        int Key;
        Node left;
        Node right;

        Node(int key) {
            this.Key = key;
        }
    }

    Node root;

    // Returns depth of leftmost leaf.
    public int depth(Node node) {
        int d = 0;
        while (node != null) {
            d++;
            node = node.left;
        }
        return d;
    }

    /* This function tests if a binary tree is perfect
    or not. It basically checks for two things :
    1) All leaves are at same level
    2) All internal nodes have two children */
    public boolean isPerfectBinaryTree(Node root, int d, int level) {
        // An empty tree is perfect
        if (root == null)
            return true;

        // If leaf node, then its depth must be same as
        // depth of all other leaves.
        if (root.left == null && root.right == null)
            return (d == level + 1);

        // If internal node and one child is empty
        if (root.left == null || root.right == null)
            return false;

        // Left and right subtrees must be perfect.
        return isPerfectBinaryTree(root.left, d, level + 1) && isPerfectBinaryTree(root.right, d, level + 1);
    }

    public boolean isPerfect(Node node) {
        int d = depth(node);
        return isPerfectBinaryTree(node, d, 0);
    }

    public static void main(String[] args) {
        PerfectBinaryTree tree = new PerfectBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        if (tree.isPerfect(tree.root))
            System.out.print("The tree is a perfect binary tree");
        else
            System.out.print("The tree is not a perfect binary tree");
    }
}
