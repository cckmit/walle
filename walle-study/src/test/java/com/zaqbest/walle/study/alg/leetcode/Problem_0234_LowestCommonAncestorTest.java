package com.zaqbest.walle.study.alg.leetcode;

import com.zaqbest.walle.study.alg.common.TreeNode;
import com.zaqbest.walle.study.alg.utils.TreeUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem_0234_LowestCommonAncestorTest {

    @Test
    public void lowestCommonAncestor() {
        TreeNode root = TreeUtils.buildTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeNode p = TreeUtils.findNode(root, 5);
        TreeNode q = TreeUtils.findNode(root, 1);
        TreeNode except = TreeUtils.findNode(root, 3);

        Problem_0236_LowestCommonAncestor solution = new Problem_0236_LowestCommonAncestor();
        Assertions.assertEquals(except, solution.lowestCommonAncestor(root, p, q));

    }
}