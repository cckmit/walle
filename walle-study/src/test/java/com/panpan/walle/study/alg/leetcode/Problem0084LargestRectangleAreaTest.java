package com.panpan.walle.study.alg.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;

public class Problem0084LargestRectangleAreaTest extends TestCase {

    public void testLargestRectangleArea() {
        Problem_0084_LargestRectangleArea solution = new Problem_0084_LargestRectangleArea();
        Assert.assertEquals(10, solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    public void testlargestRectangleArea_BruteForce(){
        Problem_0084_LargestRectangleArea solution = new Problem_0084_LargestRectangleArea();
        Assert.assertEquals(10, solution.largestRectangleArea_BruteForce(new int[]{2,1,5,6,2,3}));
    }
}