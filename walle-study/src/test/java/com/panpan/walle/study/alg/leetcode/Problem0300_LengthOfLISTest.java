package com.panpan.walle.study.alg.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class Problem0300_LengthOfLISTest {

    @Test
    void lengthOfLIS() {
        Problem_0300_LengthOfLIS solution = new Problem_0300_LengthOfLIS();
        int size = solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        Assert.assertEquals(4, size);
    }
}