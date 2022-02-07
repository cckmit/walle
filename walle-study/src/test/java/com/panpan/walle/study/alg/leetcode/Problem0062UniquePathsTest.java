package com.panpan.walle.study.alg.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;

public class Problem0062UniquePathsTest extends TestCase {

    public void testUniquePaths() {
        Problem_0062_UniquePaths solution = new Problem_0062_UniquePaths();
        Assert.assertEquals(28, solution.uniquePaths(3, 7));
        Assert.assertEquals(3, solution.uniquePaths(3, 2));
    }
}