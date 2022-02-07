package com.panpan.walle.study.alg.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Problem0033SearchRotatedArrayTest {

    @Test
    public void test(){
        Problem_0033_SearchRotatedArray solution = new Problem_0033_SearchRotatedArray();
        Assert.assertEquals(solution.search(new int[]{4,5,6,7,0,1,2}, 0), 4);
        Assert.assertEquals(solution.search(new int[]{1}, 0), -1);
        Assert.assertEquals(1, solution.search(new int[]{1, 3}, 3));
    }
}