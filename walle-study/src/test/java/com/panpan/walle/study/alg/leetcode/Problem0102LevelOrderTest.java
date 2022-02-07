package com.panpan.walle.study.alg.leetcode;

import com.panpan.walle.study.alg.common.TreeNode;
import com.panpan.walle.study.alg.utils.TreeUtils;
import org.junit.Test;

public class Problem0102LevelOrderTest {

    @Test
    public void levelOrder() {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root = TreeUtils.buildTree(preorder, inorder);

        Problem_0102_LevelOrder solution = new Problem_0102_LevelOrder();
        System.out.println(solution.levelOrder(root));
    }
}