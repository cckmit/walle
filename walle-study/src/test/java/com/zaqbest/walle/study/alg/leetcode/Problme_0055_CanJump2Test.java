package com.zaqbest.walle.study.alg.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problme_0055_CanJump2Test {
    @Test
    public void test(){
        Problem_0055_CanJumpV2 solution = new Problem_0055_CanJumpV2();
        Assertions.assertEquals(true, solution.canJump(new int[]{2,3,1,1,4}));
        Assertions.assertEquals(false, solution.canJump(new int[]{3,2,1,0,4}));
    }
}