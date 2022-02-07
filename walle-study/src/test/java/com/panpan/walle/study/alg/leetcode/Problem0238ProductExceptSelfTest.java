package com.panpan.walle.study.alg.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class Problem0238ProductExceptSelfTest {

    @Test
    void productExceptSelf() {
        Problem_0238_ProductExceptSelf solution = new Problem_0238_ProductExceptSelf();
        Assert.assertArrayEquals(new int[]{24,12,8,6}, solution.productExceptSelf(new int[]{1,2,3,4}));
    }
}