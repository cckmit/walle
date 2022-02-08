package com.zaqbest.walle.study.alg;

import com.zaqbest.walle.study.alg.classic.BiSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BiSearchTest {
    @Test
    public void Test() {
        int[] array = new int[]{1,2,3,4,5,6,7};
        int[] nullArray = null;

        Assertions.assertEquals(-1, BiSearch.biSearch(nullArray, 3));
        Assertions.assertEquals(-1, BiSearch.biSearch(nullArray, 0));
        Assertions.assertEquals(0, BiSearch.biSearch(array, 1));
        Assertions.assertEquals(-1, BiSearch.biSearch(array, 11));
        Assertions.assertEquals(3, BiSearch.biSearch(array, 4));
    }
}
