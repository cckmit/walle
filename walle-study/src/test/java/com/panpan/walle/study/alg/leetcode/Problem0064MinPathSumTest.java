package com.panpan.walle.study.alg.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Problem0064MinPathSumTest {

    @Test
    public void minPathSum() {
        Problem_0064_MinPathSum solution = new Problem_0064_MinPathSum();
        Assert.assertEquals(7, solution.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}