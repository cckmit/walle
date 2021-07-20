package com.panpan.walle.study.alg.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;

public class MergeSolutionTest extends TestCase {

    public void testMerge() {
        MergeSolution solution = new MergeSolution();
        int[][] data = new int[][]{
                {1,3},
                {2,6},
                {8,10},
                {15,18},
        };
        int [][] expected = new int[][]{{1,6},{8,10},{15,18}};
        Assert.assertArrayEquals(expected, solution.merge(data));
    }

    public void testMerge2() {
        MergeSolution solution = new MergeSolution();
        int[][] data = new int[][]{
                {1,4},
                {4,5}
        };
        int [][] expected = new int[][]{{1,5}};
        Assert.assertArrayEquals(expected, solution.merge(data));
    }
}