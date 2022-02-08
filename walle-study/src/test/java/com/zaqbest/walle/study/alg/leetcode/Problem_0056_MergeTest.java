package com.zaqbest.walle.study.alg.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem_0056_MergeTest {

    @Test
    public void testMerge() {
        Problem_0056_Merge solution = new Problem_0056_Merge();
        int[][] data = new int[][]{
                {1,3},
                {2,6},
                {8,10},
                {15,18},
        };
        int [][] expected = new int[][]{{1,6},{8,10},{15,18}};
        Assertions.assertArrayEquals(expected, solution.merge(data));
    }

    public void testMerge2() {
        Problem_0056_Merge solution = new Problem_0056_Merge();
        int[][] data = new int[][]{
                {1,4},
                {4,5}
        };
        int [][] expected = new int[][]{{1,5}};
        Assertions.assertArrayEquals(expected, solution.merge(data));
    }
}