package com.ajaymourya;

public class BinaryTreeTraversal {
    static class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }

    Node root;

    BinaryTreeTraversal() {
        root = null;
    }

    public void inorder(Node node) {
        if (node == null)
            return;
        //Traverse left
        inorder(node.left);
        //Traverse the root
        System.out.print(node.key + "->");
        //Traverse right
        inorder(node.right);
    }

    public void preorder(Node node) {
        if (node == null)
            return;
        //Traverse the root
        System.out.print(node.key + "->");
        //Traverse left
        preorder(node.left);
        //Traverse right
        preorder(node.right);
    }

    public void postorder(Node node) {
        if (node == null)
            return;
        //Traverse left
        postorder(node.left);
        //Traverse right
        postorder(node.right);
        //Traverse the root
        System.out.print(node.key + "->");
    }

    public static void main(String[] args) {
        BinaryTreeTraversal tree = new BinaryTreeTraversal();
        tree.root = new Node(4);
        tree.root.left = new Node(5);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(8);

        System.out.println("Inorder traversal");
        tree.inorder(tree.root);

        System.out.println("\nPreorder traversal ");
        tree.preorder(tree.root);

        System.out.println("\nPostorder traversal");
        tree.postorder(tree.root);
    }
}
