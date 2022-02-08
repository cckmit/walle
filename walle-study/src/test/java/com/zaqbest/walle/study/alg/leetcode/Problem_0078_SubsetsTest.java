package com.zaqbest.walle.study.alg.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Problem_0078_SubsetsTest {

    @Test
    public void testSubsets() {
        Problem_0078_Subsets solution = new Problem_0078_Subsets();
        int[] input = new int[]{1,2,3,4,5};
        List<List<Integer>> except = new ArrayList<>();

        System.out.println(solution.subsets(input));
    }
}