package com.ajaymourya.questions.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class PostorderTraversalRecursive {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        inorder(node.left, list);
        inorder(node.right, list);
        list.add(node.val);
    }
}

class PostorderTraversalIterative {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> lst = new ArrayList<Integer>();

        if (root == null)
            return lst;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        TreeNode prev = null;
        while (!stack.empty()) {
            TreeNode curr = stack.peek();

            // go down the tree.
            //check if current node is leaf, if so, process it and pop stack,
            //otherwise, keep going down
            if (prev == null || prev.left == curr || prev.right == curr) {
                //prev == null is the situation for the root node
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    stack.pop();
                    lst.add(curr.val);
                }

                //go up the tree from left node
                //need to check if there is a right child
                //if yes, push it to stack
                //otherwise, process parent and pop stack
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    stack.pop();
                    lst.add(curr.val);
                }

                //go up the tree from right node
                //after coming back from right node, process parent node and pop stack.
            } else if (curr.right == prev) {
                stack.pop();
                lst.add(curr.val);
            }

            prev = curr;
        }

        return lst;
    }
}

// The solution is simple but it does not traverses the tree in post order
class PostorderTraversalIterativeSimple {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.addFirst(node.val);
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
        return list;
    }
}
