package com.panpan.walle.study.alg.leetcode;

import com.panpan.walle.study.alg.common.Node;
import com.panpan.walle.study.alg.utils.NodeUtil;

/**
 * 142: 环形链表II
 *
 *
 * <p>{@link HasCycleSolution#hasCycle(ListNode)}
 *
 * <p>
 *     算法描述：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
 * </p>
 */
public class DetectCycleSolution {
    public Node detectCycle(Node head) {
        if (head == null || head.next == null)
            return null;

        Node fast = head.next.next;
        Node slow = head.next;

        while (slow != fast){
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
