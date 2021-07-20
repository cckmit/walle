package com.panpan.walle.study.alg.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;

public class SortColorsSolutionTest extends TestCase {

    public void testSortColors() {
        SortColorsSolution solution = new SortColorsSolution();
        int nums[] = new int[]{1,1,1,0,0,2,0,2,2};
        solution.sortColors(nums);
        Assert.assertArrayEquals(new int[]{0,0,0,1,1,1,2,2,2}, nums);
    }
}