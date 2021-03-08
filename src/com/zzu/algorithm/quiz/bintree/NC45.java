package com.zzu.algorithm.quiz.bintree;

import com.zzu.algorithm.tool.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class NC45 {
    /**
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders(TreeNode root) {
        // write code here
        preorder(root);
        inorder(root);
        postorder(root);

        return new int[][]{pre.stream().mapToInt(k -> k).toArray(), in.stream().mapToInt(k -> k).toArray(), post.stream().mapToInt(k -> k).toArray()};
    }

    public List<Integer> pre = new LinkedList<>();
    public List<Integer> in = new LinkedList<>();
    public List<Integer> post = new LinkedList<>();

    private void postorder(TreeNode root) {
        if(root==null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        post.add(root.val);
    }

    private void inorder(TreeNode root) {
        if(root==null) {
            return;
        }
        inorder(root.left);
        in.add(root.val);
        inorder(root.right);

    }

    public void preorder (TreeNode root){
        if(root==null) {
            return;
        }
        pre.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }


}
