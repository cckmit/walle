package com.panpan.walle.study.alg.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WordBreakSolutionTest {

    @Test
    public void wordBreak_OK() {
        WordBreakSolution solution = new WordBreakSolution();
        List<String> wordDict = new ArrayList<String>(){{
            add("apple");
            add("pen");

        }};
        Assert.assertEquals(true, solution.wordBreak("applepenapple", wordDict));
    }

    @Test
    public void wordBreak_NG() {
        WordBreakSolution solution = new WordBreakSolution();
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