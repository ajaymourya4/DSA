package com.ajaymourya.questions.binarytree;

import java.util.HashMap;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Medium
 *
 * 3661
 *
 * 100
 *
 * Add to List
 *
 * Share
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */

class BinaryTreeFromPreorderAndInoderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int inStart = 0;
        int inEnd = inorder.length - 1;
        int preStart = 0;
        int preEnd = preorder.length - 1;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i <= inEnd; i++) {
            hm.put(inorder[i], i);
        }
        return buildTree(inorder, inStart, inEnd, preorder, preStart, preEnd, hm);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd, HashMap<Integer, Integer> hm) {
        if (inStart > inEnd || preStart > preEnd)
            return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int k = hm.get(rootVal);

        root.left = buildTree(inorder, inStart, k - 1, preorder, preStart + 1, preStart + (k - inStart), hm);
        root.right = buildTree(inorder, k + 1, inEnd, preorder, preStart + (k - inStart) + 1, preEnd, hm);

        return root;
    }
}
