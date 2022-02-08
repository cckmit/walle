package com.zaqbest.walle.study.alg.leetcode;

import org.junit.jupiter.api.Assertions;

public class Problem_0075_SortColorsTest {

    public void testSortColors() {
        Problem_0075_SortColors solution = new Problem_0075_SortColors();
        int nums[] = new int[]{1,1,1,0,0,2,0,2,2};
        solution.sortColors(nums);
        Assertions.assertArrayEquals(new int[]{0,0,0,1,1,1,2,2,2}, nums);
    }
}