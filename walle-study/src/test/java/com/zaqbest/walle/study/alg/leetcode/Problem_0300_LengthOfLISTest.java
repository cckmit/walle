package com.zaqbest.walle.study.alg.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem_0300_LengthOfLISTest {

    @Test
    void lengthOfLIS() {
        Problem_0300_LengthOfLIS solution = new Problem_0300_LengthOfLIS();
        int size = solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        Assertions.assertEquals(4, size);
    }
}