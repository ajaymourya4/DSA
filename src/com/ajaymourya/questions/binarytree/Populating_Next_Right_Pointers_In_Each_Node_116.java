package com.ajaymourya.questions.binarytree;

import java.util.LinkedList;
import java.util.Queue;

class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
                if (prev != null)
                    prev.next = current;
                prev = current;
            }
        }

        return root;
    }
}

/**
 * Time -> O(N)
 * Space -> O(N)
 */

class SolutionWithBetterConstantSpace {
    public Node connect(Node root) {
        if (root == null) return null;
        Node prev = root;
        Node cur = null;

        while (prev.left != null) {
            cur = prev;

            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }

            prev = prev.left;
        }

        return root;
    }
}

/**
 * Time -> O(N)
 * Space -> O(1)
 */

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
