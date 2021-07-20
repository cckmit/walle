package com.panpan.walle.study.alg.leetcode;

import com.panpan.walle.study.alg.common.TreeNode;

/**
 * 104: 二叉树的最大深度
 */
public class MaxDepthSolution {
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        else return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
