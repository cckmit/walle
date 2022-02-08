package com.zaqbest.walle.study.alg.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem_0064_MinPathSumTest {

    @Test
    public void minPathSum() {
        Problem_0064_MinPathSum solution = new Problem_0064_MinPathSum();
        Assertions.assertEquals(7, solution.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}