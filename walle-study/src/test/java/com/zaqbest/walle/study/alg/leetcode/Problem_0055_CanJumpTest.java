package com.zaqbest.walle.study.alg.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem_0055_CanJumpTest {
    @Test
    public void test(){
        Problem_0055_CanJump solution = new Problem_0055_CanJump();
        Assertions.assertEquals(true, solution.canJump(new int[]{2,3,1,1,4}));
        Assertions.assertEquals(false, solution.canJump(new int[]{3,2,1,0,4}));
    }

}