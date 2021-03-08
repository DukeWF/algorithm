package com.zzu.algorithm.quiz.bintree;

import com.zzu.algorithm.tool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NC15 {
    /**
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here
        //1. 异常判断
        //2. BFS+queue
        //3. 输出

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        //1. 异常判断
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>() {
            {
                add(root);
            }
        };
        //2. BFS+queue
        while (!q.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = q.size(); i > 0; i--) {
                TreeNode t = q.poll();
                assert t != null;
                temp.add(t.val);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            res.add(temp);
        }
        //3. 输出
        return res;
    }
}
