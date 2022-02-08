package com.zaqbest.walle.study.alg.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem_0033_SearchRotatedArrayTest {

    @Test
    public void test(){
        Problem_0033_SearchRotatedArray solution = new Problem_0033_SearchRotatedArray();
        Assertions.assertEquals(solution.search(new int[]{4,5,6,7,0,1,2}, 0), 4);
        Assertions.assertEquals(solution.search(new int[]{1}, 0), -1);
        Assertions.assertEquals(1, solution.search(new int[]{1, 3}, 3));
    }
}