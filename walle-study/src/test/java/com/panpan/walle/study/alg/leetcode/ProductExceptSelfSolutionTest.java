package com.panpan.walle.study.alg.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductExceptSelfSolutionTest {

    @Test
    void productExceptSelf() {
        ProductExceptSelfSolution solution = new ProductExceptSelfSolution();
        Assert.assertArrayEquals(new int[]{24,12,8,6}, solution.productExceptSelf(new int[]{1,2,3,4}));
    }
}