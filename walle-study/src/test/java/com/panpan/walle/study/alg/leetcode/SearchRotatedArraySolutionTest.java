package com.panpan.walle.study.alg.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class SearchRotatedArraySolutionTest {

    @Test
    public void test(){
        SearchRotatedArraySolution solution = new SearchRotatedArraySolution();
        Assert.assertEquals(solution.search(new int[]{4,5,6,7,0,1,2}, 0), 4);
        Assert.assertEquals(solution.search(new int[]{1}, 0), -1);
        Assert.assertEquals(1, solution.search(new int[]{1, 3}, 3));
    }
}