package com.zzu.algorithm.quiz.bst;

import com.zzu.algorithm.tool.TreeNode;

public class _538 {
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    int sum = 0;

    public void traverse(TreeNode root) {
        if (root == null) return;

        //BST先右后左的逆向中序遍历，可以获得一个降序的列表
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}
