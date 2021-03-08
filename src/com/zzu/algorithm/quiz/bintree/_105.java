package com.zzu.algorithm.quiz.bintree;

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
public class _105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,
                     inorder,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd){
        if(preStart>preEnd||inStart>inEnd) return null;

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        //找到rootVal在中序遍历数组的index
        int index = inStart;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==rootVal){
                index=i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);

        int leftSize = index-inStart;
        root.left = build(preorder,preStart+1,preStart+leftSize,inorder,inStart,index-1);
        root.right = build(preorder,preStart+leftSize+1,preEnd,inorder,index+1,inEnd);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        _105 obj = new _105();
        TreeNode t = obj.buildTree(preorder,inorder);

        t.showTree();
    }
}
