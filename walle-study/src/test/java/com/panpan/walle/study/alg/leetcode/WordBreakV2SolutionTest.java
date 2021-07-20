package com.panpan.walle.study.alg.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WordBreakV2SolutionTest {

    @Test
    public void wordBreak() {
        WordBreakV2Solution solution = new WordBreakV2Solution();
        List<String> wordDict = new ArrayList<>();
        String  s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")
                .stream().forEach(e->wordDict.add(e));
        wordDict.sort((a,b)->b.length()-a.length());

        long start = System.currentTimeMillis();
        boolean result = solution.wordBreak(s, wordDict);
        System.out.println(result);
        System.out.println("执行时间: " + (System.currentTimeMillis() - start));
    }
}