package com.panpan.walle.study.alg.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CanJumpSolutionTest {
    @Test
    public void test(){
        CanJumpSolution solution = new CanJumpSolution();
        Assert.assertEquals(true, solution.canJump(new int[]{2,3,1,1,4}));
        Assert.assertEquals(false, solution.canJump(new int[]{3,2,1,0,4}));
    }

}