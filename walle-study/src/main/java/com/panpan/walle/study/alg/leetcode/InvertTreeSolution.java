package com.panpan.walle.study.alg.leetcode;

import com.panpan.walle.study.alg.common.ListNode;
import com.panpan.walle.study.alg.common.TreeNode;

/**
 * 226:翻转二叉树
 */
public class InvertTreeSolution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
