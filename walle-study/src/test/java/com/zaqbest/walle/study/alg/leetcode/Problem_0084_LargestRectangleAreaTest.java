package com.zaqbest.walle.study.alg.leetcode;

import org.junit.jupiter.api.Assertions;

public class Problem_0084_LargestRectangleAreaTest {

    public void testLargestRectangleArea() {
        Problem_0084_LargestRectangleArea solution = new Problem_0084_LargestRectangleArea();
        Assertions.assertEquals(10, solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    public void testlargestRectangleArea_BruteForce(){
        Problem_0084_LargestRectangleArea solution = new Problem_0084_LargestRectangleArea();
        Assertions.assertEquals(10, solution.largestRectangleArea_BruteForce(new int[]{2,1,5,6,2,3}));
    }
}