package com.panpan.walle.study.alg.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ClimbStairsSolutionTest extends TestCase {

    @Test
    public void test(){
        ClimbStairsSolution solution = new ClimbStairsSolution();
        Assert.assertEquals(3, solution.climbStairs(3));
        Assert.assertEquals(3, solution.climbStairs(3));
    }
}