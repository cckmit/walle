package com.panpan.walle.study.alg.leetcode;

import com.panpan.walle.study.alg.common.TreeNode;
import com.panpan.walle.study.alg.common.TreeUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class LevelOrderSolutionTest {

    @Test
    public void levelOrder() {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root = TreeUtils.buildTree(preorder, inorder);

        LevelOrderSolution solution = new LevelOrderSolution();
        System.out.println(solution.levelOrder(root));
    }
}