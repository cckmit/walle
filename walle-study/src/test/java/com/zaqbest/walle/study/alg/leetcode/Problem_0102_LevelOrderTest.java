package com.zaqbest.walle.study.alg.leetcode;

import com.zaqbest.walle.study.alg.common.TreeNode;
import com.zaqbest.walle.study.alg.utils.TreeUtils;
import org.junit.jupiter.api.Test;

public class Problem_0102_LevelOrderTest {

    @Test
    public void levelOrder() {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root = TreeUtils.buildTree(preorder, inorder);

        Problem_0102_LevelOrder solution = new Problem_0102_LevelOrder();
        System.out.println(solution.levelOrder(root));
    }
}