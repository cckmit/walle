package com.panpan.walle.study.alg.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumSquaresSolutionTest {

    @Test
    void numSquares() {
        NumSquaresSolution solution = new NumSquaresSolution();
        Assert.assertEquals(3, solution.numSquares(12));
        Assert.assertEquals(2, solution.numSquares(13));
    }
}