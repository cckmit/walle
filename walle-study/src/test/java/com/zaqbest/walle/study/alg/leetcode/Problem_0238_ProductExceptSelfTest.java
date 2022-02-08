package com.zaqbest.walle.study.alg.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem_0238_ProductExceptSelfTest {

    @Test
    void productExceptSelf() {
        Problem_0238_ProductExceptSelf solution = new Problem_0238_ProductExceptSelf();
        Assertions.assertArrayEquals(new int[]{24,12,8,6}, solution.productExceptSelf(new int[]{1,2,3,4}));
    }
}