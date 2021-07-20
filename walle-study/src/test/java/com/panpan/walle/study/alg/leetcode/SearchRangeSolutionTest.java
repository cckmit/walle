package com.panpan.walle.study.alg.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchRangeSolutionTest {
    @Test
    public void test(){
        SearchRangeSolution solution = new SearchRangeSolution();
        Assert.assertArrayEquals(new int[]{3,4}, solution.searchRange(new int[]{5,7,7,8,8,10}, 8));
        Assert.assertArrayEquals(new int[]{-1,-1}, solution.searchRange(new int[]{5,7,7,8,8,10}, 6));
        Assert.assertArrayEquals(new int[]{-1,-1}, solution.searchRange(new int[]{}, 1));
    }
}