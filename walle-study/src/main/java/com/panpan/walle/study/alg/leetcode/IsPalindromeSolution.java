package com.panpan.walle.study.alg.leetcode;

import com.panpan.walle.study.alg.common.Node;
import com.panpan.walle.study.alg.utils.NodeUtil;

import java.util.Arrays;
import java.util.Stack;

/**
 * 234: 回文链表
 *
 * 算法描述：
 * 使用栈记录倒序的情况 空间复杂度O(n)
 */
public class IsPalindromeSolution {
    public static void main(String[] args) {
        IsPalindromeSolution solution = new IsPalindromeSolution();
        Node head = NodeUtil.buildList(Arrays.asList(1,2,2,1));
        solution.isPalindrome(head);
    }
    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;
        Stack<Integer> stack = new Stack<>();
        Node p =head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }

        p = head;
        while (p != null){
            if (p.val != stack.pop())
                return false;
            p = p.next;
        }
        return true;
    }
}
