package com.zaqbest.walle.study.alg.antfin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem_0205_IsIsomorphicSolutionTest {

    @Test
    public void test(){
        IsIsomorphicSolution solution =new IsIsomorphicSolution();
        Assertions.assertEquals(true, solution.isIsomorphic("egg", "add"));
    }

}