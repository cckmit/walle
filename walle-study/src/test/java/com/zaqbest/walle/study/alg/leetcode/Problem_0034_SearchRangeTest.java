package com.zaqbest.walle.study.alg.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem_0034_SearchRangeTest {
    @Test
    public void test(){
        Problem_0034_SearchRange solution = new Problem_0034_SearchRange();
        Assertions.assertArrayEquals(new int[]{3,4}, solution.searchRange(new int[]{5,7,7,8,8,10}, 8));
        Assertions.assertArrayEquals(new int[]{-1,-1}, solution.searchRange(new int[]{5,7,7,8,8,10}, 6));
        Assertions.assertArrayEquals(new int[]{-1,-1}, solution.searchRange(new int[]{}, 1));
    }
}