package com.zzu.algorithm.quiz.bintree;

import com.zzu.algorithm.tool.TreeNode;

public class _106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode build(int[] inorder, int ins, int ine, int[] postorder, int pos, int poe){
        if(ins>ine||pos>poe) return null;

        int rootVal = postorder[poe];
        int index = ins;
        for(int i=ins;i<=ine;i++){
            if(inorder[i]==rootVal){
                index=i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);

        int leftSize = index-ins;
        root.left = build(inorder,ins,index-1,postorder,pos,pos+leftSize-1);
        root.right = build(inorder,index+1,ine,postorder,pos+leftSize,poe-1);

        return root;
    }

    public static void main(String[] args) {
//        int[] inorder = {9,3,15,20,7};
//        int[] postorder = {9,15,7,20,3};
        int[] inorder = {2,1};
        int[] postorder = {2,1};

        _106 obj = new _106();
        TreeNode t = obj.buildTree(inorder,postorder);

        t.showTree();
    }
}
