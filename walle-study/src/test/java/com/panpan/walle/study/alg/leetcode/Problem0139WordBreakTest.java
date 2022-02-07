package com.panpan.walle.study.alg.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Problem0139WordBreakTest {

    @Test
    public void wordBreak_OK() {
        Problem_0139_WordBreak solution = new Problem_0139_WordBreak();
        List<String> wordDict = new ArrayList<String>(){{
            add("apple");
            add("pen");

        }};
        Assert.assertEquals(true, solution.wordBreak("applepenapple", wordDict));
    }

    @Test
    public void wordBreak_NG() {
        Problem_0139_WordBreak solution = new Problem_0139_WordBreak();
        List<String> wordDict = new ArrayList<String>(){{
            add("cats");
            add("dog");
            add("sand");
            add("and");
            add("cat");

        }};
        Assert.assertEquals(false, solution.wordBreak("catsandog", wordDict));
    }
}