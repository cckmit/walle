package com.panpan.walle.study.alg.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class No0300_LengthOfLISTest {

    @Test
    void lengthOfLIS() {
        No0300_LengthOfLIS solution = new No0300_LengthOfLIS();
        int size = solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        Assert.assertEquals(4, size);
    }
}