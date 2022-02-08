package com.zaqbest.walle.study.alg.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Problem_0139_WordBreakTest {

    @Test
    public void wordBreak_OK() {
        Problem_0139_WordBreak solution = new Problem_0139_WordBreak();
        List<String> wordDict = new ArrayList<String>(){{
            add("apple");
            add("pen");

        }};
        Assertions.assertEquals(true, solution.wordBreak("applepenapple", wordDict));
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
        Assertions.assertEquals(false, solution.wordBreak("catsandog", wordDict));
    }
}