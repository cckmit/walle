package com.panpan.walle.study.alg.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;

public class LargestRectangleAreaSolutionTest extends TestCase {

    public void testLargestRectangleArea() {
        LargestRectangleAreaSolution solution = new LargestRectangleAreaSolution();
        Assert.assertEquals(10, solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    public void testlargestRectangleArea_BruteForce(){
        LargestRectangleAreaSolution solution = new LargestRectangleAreaSolution();
        Assert.assertEquals(10, solution.largestRectangleArea_BruteForce(new int[]{2,1,5,6,2,3}));
    }
}