package com.panpan.walle.study.alg.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;

public class Problem0056MergeTest extends TestCase {

    public void testMerge() {
        Problem_0056_Merge solution = new Problem_0056_Merge();
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
        Problem_0056_Merge solution = new Problem_0056_Merge();
        int[][] data = new int[][]{
                {1,4},
                {4,5}
        };
        int [][] expected = new int[][]{{1,5}};
        Assert.assertArrayEquals(expected, solution.merge(data));
    }
}