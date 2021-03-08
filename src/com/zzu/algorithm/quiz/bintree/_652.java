package com.zzu.algorithm.quiz.bintree;

import com.zzu.algorithm.tool.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
//你需要知道以下两点：
//
//1、以我为根的这棵二叉树（子树）长啥样？使用后序遍历对当前root的子树进行模式构建
//
//2、以其他节点为根的子树都长啥样？是否有重复？使用HashSet保存子树，如存在重复即可发现
public class _652 {
    List<TreeNode> findDuplicateSubtrees(TreeNode root){
        traverse(root);
        return res;
    }

//  识别树类型：对子树进行序列化
    String traverse(TreeNode root){
        if(root==null) return "#";
        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right + "," + root.val;

//      使用HashMap进行数量记录
        int freq = memo.getOrDefault(subTree,0);
        if(freq==1){
            res.add(root);
        }
        memo.put(subTree,freq+1);
        return subTree;
    }
//  使用HashSet记录子树
    HashMap<String,Integer> memo = new HashMap<>();
    LinkedList<TreeNode> res = new LinkedList<>();



}
