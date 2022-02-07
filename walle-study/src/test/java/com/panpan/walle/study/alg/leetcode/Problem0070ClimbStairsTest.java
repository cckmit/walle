package com.panpan.walle.study.alg.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class Problem0070ClimbStairsTest extends TestCase {

    @Test
    public void test(){
        Problem_0070_ClimbStairs solution = new Problem_0070_ClimbStairs();
        Assert.assertEquals(3, solution.climbStairs(3));
        Assert.assertEquals(3, solution.climbStairs(3));
    }
}