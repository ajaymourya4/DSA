package com.ajaymourya.questions.binarytree;

import java.util.LinkedList;
import java.util.Queue;

class SerializeDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        sb.append(String.valueOf(root.val));
        sb.append(' ');
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null) sb.append("null ");
            else {
                sb.append(String.valueOf(node.left.val));
                sb.append(' ');
                queue.offer(node.left);
            }
            if (node.right == null) sb.append("null ");
            else {
                sb.append(String.valueOf(node.right.val));
                sb.append(' ');
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] nodes = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (nodes[i].equals("null")) node.left = null;
            else {
                node.left = new TreeNode(Integer.valueOf(nodes[i]));
                queue.offer(node.left);
            }
            i++;
            if (nodes[i].equals("null")) node.right = null;
            else {
                node.right = new TreeNode(Integer.valueOf(nodes[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
