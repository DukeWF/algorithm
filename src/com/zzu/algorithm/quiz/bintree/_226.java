package com.zzu.algorithm.quiz.bintree;
//LeetCode 226

import com.zzu.algorithm.tool.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class _226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }

        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;

    }
}
