package com.panpan.walle.study.alg.antfin;

import org.junit.Assert;
import org.junit.Test;

public class IsIsomorphicSolutionTest {

    @Test
    public void test(){
        IsIsomorphicSolution solution =new IsIsomorphicSolution();
        Assert.assertEquals(true, solution.isIsomorphic("egg", "add"));
    }

}