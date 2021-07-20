package com.panpan.walle.study.alg.leetcode;

import com.panpan.walle.study.alg.common.ListNode;

/**
 * 160: 相交链表
 */
public class GetIntersectionNodeSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        int aLen = 0;
        int bLen = 0;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != null) {
            pA = pA.next;
            aLen++;
        }

        while (pB != null){
            pB = pB.next;
            bLen++;
        }

        //最后一个节点不一样，没有交叉
        if (pA != pB) return null;

        pA = headA;
        pB = headB;
        if (aLen > bLen){
            for(int i = 0; i < aLen - bLen;i++)
                pA = pA.next;
        } else if (bLen > aLen){
            for(int i = 0; i < bLen - aLen;i++)
                pB = pB.next;
        }
        while (pA != pB){
            pA = pA.next;
            pB = pB.next;
        }
        return pA;
    }
}
