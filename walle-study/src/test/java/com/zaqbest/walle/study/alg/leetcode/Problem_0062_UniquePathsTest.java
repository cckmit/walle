package com.zaqbest.walle.study.alg.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem_0062_UniquePathsTest {

    @Test
    public void testUniquePaths() {
        Problem_0062_UniquePaths solution = new Problem_0062_UniquePaths();
        Assertions.assertEquals(28, solution.uniquePaths(3, 7));
        Assertions.assertEquals(3, solution.uniquePaths(3, 2));
    }
}