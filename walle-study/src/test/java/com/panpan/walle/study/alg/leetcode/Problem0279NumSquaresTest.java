package com.panpan.walle.study.alg.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class Problem0279NumSquaresTest {

    @Test
    void numSquares() {
        Problem_0279_NumSquares solution = new Problem_0279_NumSquares();
        Assert.assertEquals(3, solution.numSquares(12));
        Assert.assertEquals(2, solution.numSquares(13));
    }
}