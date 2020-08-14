package com.ajaymourya.questions.binarytree;

import java.util.LinkedList;
import java.util.Queue;

class RecursiveTopDownApproach {
    int answer;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        answer = 1;
        depth(root, answer);
        return answer;
    }

    public void depth(TreeNode node, int depth) {
        if (node == null)
            return;
        if (node.left == null && node.right == null)
            answer = Math.max(answer, depth);
        depth(node.left, depth + 1);
        depth(node.right, depth + 1);
    }
}

class RecursiveBottomUpApproach {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        return Math.max(left_depth, right_depth) + 1;
    }
}

class IterativeBFSApproach {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            depth++;
        }
        return depth;
    }
}
