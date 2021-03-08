package com.zzu.algorithm.quiz.bst;

import com.zzu.algorithm.tool.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class _95 {
    public List<TreeNode> generateTrees(int n){
        //base case
        if (n==0) return new LinkedList<>();
        return build(1,n);
    }
    public List<TreeNode> build(int lo, int hi) {
        List<TreeNode> res = new LinkedList<>();

        // base case
        if(lo>hi) {
            res.add(null);
            return res;
        }

        //1. 穷举所有可能
        for(int i=lo;i<hi;i++){
            List<TreeNode> leftTree = build(lo,i-1);
            List<TreeNode> rightTree = build(i+1,hi);

            //2. 以当前节点为根，穷举左右子树可能
            for(TreeNode left: leftTree){
                for(TreeNode right: rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
