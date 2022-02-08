package com.zaqbest.walle.study.alg.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem_0279_NumSquaresTest {

    @Test
    void numSquares() {
        Problem_0279_NumSquares solution = new Problem_0279_NumSquares();
        Assertions.assertEquals(3, solution.numSquares(12));
        Assertions.assertEquals(2, solution.numSquares(13));
    }
}