package com.panpan.walle.study.alg.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinPathSumSolutionTest {

    @Test
    public void minPathSum() {
        MinPathSumSolution solution = new MinPathSumSolution();
        Assert.assertEquals(7, solution.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}