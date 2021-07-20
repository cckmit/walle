package com.panpan.walle.study.alg.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;

public class UniquePathsSolutionTest extends TestCase {

    public void testUniquePaths() {
        UniquePathsSolution solution = new UniquePathsSolution();
        Assert.assertEquals(28, solution.uniquePaths(3, 7));
        Assert.assertEquals(3, solution.uniquePaths(3, 2));
    }
}