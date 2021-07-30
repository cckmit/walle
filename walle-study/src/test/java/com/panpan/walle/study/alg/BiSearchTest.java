package com.panpan.walle.study.alg;

import com.panpan.walle.study.alg.classic.BiSearch;
import org.junit.Assert;
import org.junit.Test;

public class BiSearchTest {
    @Test
    public void Test() {
        int[] array = new int[]{1,2,3,4,5,6,7};
        int[] nullArray = null;

        Assert.assertEquals(-1, BiSearch.biSearch(nullArray, 3));
        Assert.assertEquals(-1, BiSearch.biSearch(nullArray, 0));
        Assert.assertEquals(0, BiSearch.biSearch(array, 1));
        Assert.assertEquals(-1, BiSearch.biSearch(array, 11));
        Assert.assertEquals(3, BiSearch.biSearch(array, 4));
    }
}
