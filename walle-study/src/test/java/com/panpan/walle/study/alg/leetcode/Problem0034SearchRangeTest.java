package com.panpan.walle.study.alg.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Problem0034SearchRangeTest {
    @Test
    public void test(){
        Problem_0034_SearchRange solution = new Problem_0034_SearchRange();
        Assert.assertArrayEquals(new int[]{3,4}, solution.searchRange(new int[]{5,7,7,8,8,10}, 8));
        Assert.assertArrayEquals(new int[]{-1,-1}, solution.searchRange(new int[]{5,7,7,8,8,10}, 6));
        Assert.assertArrayEquals(new int[]{-1,-1}, solution.searchRange(new int[]{}, 1));
    }
}