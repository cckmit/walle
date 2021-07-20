package com.panpan.walle.study.alg.leetcode;

import com.panpan.walle.study.alg.common.ListNode;

/**
 * 141: 环形链表
 */
public class HasCycleSolution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while (slow != fast){
            if (fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }
}
