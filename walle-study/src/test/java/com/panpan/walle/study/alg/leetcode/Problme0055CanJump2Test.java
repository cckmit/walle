package com.panpan.walle.study.alg.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problme0055CanJump2Test {
    @Before
    public void setUp(){
        System.out.println("setup");
    }
    @Test
    public void test(){
        Problem_0055_CanJumpV2 solution = new Problem_0055_CanJumpV2();
        Assert.assertEquals(true, solution.canJump(new int[]{2,3,1,1,4}));
        Assert.assertEquals(false, solution.canJump(new int[]{3,2,1,0,4}));
    }
}