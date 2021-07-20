package com.panpan.walle.study.alg.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class SubsetsSolutionTest extends TestCase {

    public void testSubsets() {
        SubsetsSolution solution = new SubsetsSolution();
        int[] input = new int[]{1,2,3,4,5};
        List<List<Integer>> except = new ArrayList<>();

        System.out.println(solution.subsets(input));
    }
}