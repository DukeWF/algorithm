package com.zzu.algorithm.quiz.bst;

import com.zzu.algorithm.tool.TreeNode;

public class CRUD {
    //插入节点
    class _701 {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            //找到空位插入新节点
            if (root == null) return new TreeNode(val);

            // 通常，不需要考虑已存在该节点的情况
            //if(root.val==val) return true;

            if (root.val > val) {
                root.left = insertIntoBST(root.left, val);
                return root;
            }

            if (root.val < val) {
                root.right = insertIntoBST(root.right, val);
                return root;
            }

            return root;
        }
    }

    //删除节点
    class _450 {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;
            if (root.val == key) {
                //删除：子函数
                //1. 末端节点：无孩子--直接delete（2已经包括在内）
//                if (root.left == null && root.right == null)
//                    return null;
                //2. 只有一个非空的子节点--replace
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;
                //3. 都有，那就抽左子树最右节点或右子树最左节点来replace（剩余的情况就是左右孩子均不空）
                //找到右子树最左节点
                TreeNode minNode = getMinFromRight(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);

                //OR：找到左子树最右节点
//                    TreeNode minNode = getMinFromLeft(root.left);
//                    root.val = minNode.val;
//                    root.left = deleteNode(root.left, minNode.val);
            } else if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else{
                root.right = deleteNode(root.right, key);
            }
            return root;
        }

        public TreeNode getMinFromRight(TreeNode node) {
            while (node.left != null) node = node.left;
            return node;
        }

        public TreeNode getMinFromLeft(TreeNode node) {
            while (node.right != null) node = node.right;
            return node;
        }

    }

    //搜索
    class _700 {
        //实际上这也是BST的遍历框架，不用全遍历，用上左小右大原则
        public TreeNode searchBST(TreeNode root, int target) {
            if (root == null) return null;

            if (root.val == target) return root;

            if (root.val > target) return searchBST(root.left, target);

            return searchBST(root.right, target);
        }
    }

    //验证BST合法性
    //通过使用辅助函数，增加函数参数列表，在参数中携带额外信息，将这种约束传递给子树的所有节点
    class _98 {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }

        public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
            // base case
            if (root == null) return true;
            if (min != null && root.val <= min.val) return false;
            if (max != null && root.val >= max.val) return false;

            // 对当前节点的左右子树分别施加约束，min<左子树<root，root<右子树<max
            return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
        }
    }
}
