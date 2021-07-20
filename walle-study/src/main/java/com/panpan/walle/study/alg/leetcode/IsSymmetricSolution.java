package com.panpan.walle.study.alg.leetcode;

import cn.hutool.core.lang.tree.Tree;
import com.panpan.walle.study.alg.common.TreeNode;

/**
 * 101: 对称二叉树
 */
public class IsSymmetricSolution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right){
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;
        return dfs(left.right, right.left) && dfs(left.left, right.right);
    }
}
