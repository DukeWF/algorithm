package com.zzu.algorithm.quiz.bintree;


import com.zzu.algorithm.tool.TreeNode;

public class _654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
       return build(nums,0,nums.length-1);
    }
    public TreeNode build(int[] nums,int lo,int hi){
        if(lo>hi) return null;
        int index = -1, maxVal=Integer.MIN_VALUE;
        for (int i=lo;i<=hi;i++){
            if(maxVal<nums[i]){
                maxVal=nums[i];
                index=i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left=build(nums,lo,index-1);
        root.right=build(nums,index+1,hi);
        return root;
    }

    public static void main(String[] args) {
        int[]arr = {3,2,1,6,0,5};
        _654 obj = new _654();
        TreeNode t = obj.constructMaximumBinaryTree(arr);
        t.showTree();
    }
}
