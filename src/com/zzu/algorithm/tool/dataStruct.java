package com.zzu.algorithm.tool;

public class dataStruct {
//介绍数据结构基本操作
//    1. 遍历
//    1.1 数组线性迭代
    public void traverseArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            //访问arr[i]
            System.out.println("hello!");
        }
    }
//    1.2 链表迭代与递归
    private class ListNode{
        private int val;
        private ListNode next;
    }
    public void traverseListByIteration(ListNode head){
        for(ListNode p = head;p!=null;p=p.next){
            //访问p.val
            System.out.println("hello!");
        }
    }
    public void traverseListByRecursion(ListNode head){
        if(head==null) return;
        System.out.println("hello!");
        //访问head.val
        traverseListByRecursion(head.next);
    }
//    1.3 二叉树非线性递归遍历
    private class BinTreeNode{
        private int val;
        private BinTreeNode left,right;
    }
    public void traverseBinTree(BinTreeNode root){
        if(root==null) return;
        //根据遍历要求，访问root.val
        //前/中/后序遍历,依次放置在A/B/C处
        //A
        traverseBinTree(root.left);
        //B
        traverseBinTree(root.right);
        //C
    }
//    1.4 N叉树非线性迭代+递归遍历
    private class NTreeNode{
        private int val;
        private NTreeNode[] children;

    private NTreeNode(int val, NTreeNode[] children) {
        this.val = val;
        this.children = children;
    }
}
    public void traverseNTree(NTreeNode root){
        for (NTreeNode child: root.children){
            //根据遍历要求，访问root.val
            //前/后序遍历,依次放置在A/B处
            //A
            traverseNTree(child);
            //B
        }
    }

    public static void main(String[] args) {
        System.out.println("This is a demo of Data Struct Operation.");
    }

}
