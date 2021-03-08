package com.zzu.algorithm.quiz.bst;

public class _230 {
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    // 全树遍历，效率略低 O(N)
    public void traverse(TreeNode root, int k) {
        if (root == null) return;

        traverse(root.left, k);
        rank++;
        if (k == rank) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }

    public int res = 0;
    public int rank = 0;

    // 优化：使用优化后的带子树节点数（size）的TreeNode进行操作
    class TreeNode {
        int val;
        // 以该节点为根的树的节点总数
        int size;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode traverse(TreeNode root, int k, Object flag) {
        if (flag == null) flag = "";
        if (root == null) return null;

        if (k == root.left.size + 1) return root;
        else if (k > root.left.size + 1) traverse(root.left, k, flag);
        else traverse(root.right, k - root.size, flag);

        return null;
    }
}
