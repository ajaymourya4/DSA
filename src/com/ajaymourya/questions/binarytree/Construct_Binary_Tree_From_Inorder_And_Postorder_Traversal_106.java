package com.ajaymourya.questions.binarytree;

import java.util.HashMap;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Medium
 *
 * 1960
 *
 * 38
 *
 * Add to List
 *
 * Share
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
class BinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inStart = 0;
        int inEnd = inorder.length - 1;
        int posStart = 0;
        int posEnd = postorder.length - 1;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i <= inEnd; i++) {
            hm.put(inorder[i], i);
        }
        return buildTree(inorder, inStart, inEnd, postorder, posStart, posEnd, hm);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int posStart, int posEnd, HashMap<Integer, Integer> hm) {
        if (inStart > inEnd || posStart > posEnd)
            return null;

        int rootVal = postorder[posEnd];
        TreeNode root = new TreeNode(rootVal);

        int k = hm.get(rootVal);

        root.left = buildTree(inorder, inStart, k - 1, postorder, posStart, posStart + k - (inStart + 1), hm);
        root.right = buildTree(inorder, k + 1, inEnd, postorder, posStart + k - (inStart + 1) + 1, posEnd - 1, hm);

        return root;
    }
}
