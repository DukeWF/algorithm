package com.zzu.algorithm.quiz.bintree;
//LeetCode 114


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

public class _114 {
    public void flatten(TreeNode root) {
        //将原始问题拆分步骤解决
        //1. 拉平root的左右子树
        if (root==null) return;
        flatten(root.left);
        flatten(root.right);


        TreeNode left=root.left;
        TreeNode right=root.right;

        //2. 将左子树作为右子树
        root.left=null;
        root.right=left;

        //3. 将原先右子树拼接至左子树末尾
        TreeNode p = root;
        //考虑原始左子树是否存在，如存在则继续选右，直到最右
        while(p.right!=null){
            p=p.right;
        }
        p.right=right;
    }
}
