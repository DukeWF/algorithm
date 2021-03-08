package com.zzu.algorithm.tool;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public void showTree(){
        System.out.print("[");
        showNodeByLevel(this);
        System.out.print("]");
    }
    public void showNodeByLevel(TreeNode root){
        if(root==null) return;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            TreeNode temp = q.peek();

            if (temp.left!=null){
                q.offer(temp.left);
            }
            if (temp.right!=null) {
                q.offer(temp.right);
            }

            q.poll();

            //控制层次遍历输出
            if(!q.isEmpty()) System.out.print(temp.val+" ");
            else System.out.print(temp.val);
        }

//        Iterator ite = q.iterator();
//        while (ite.hasNext()){
//            TreeNode temp = (TreeNode) ite.next();
//            System.out.print(temp.val);
//        }

    }
}
