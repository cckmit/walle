package com.panpan.walle.study.alg.leetcode;

import com.panpan.walle.study.alg.common.ListNode;

/**
 * 问题描述
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * 处理思路：分解成两个列表的合并
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        return mergeKLists(lists, 0, lists.length -1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end){
        //一个节点的情况
        if (start == end){
            return lists[start];
        }
        //两个节点的情况
        else if (end - start == 1){
            return mergeTwoLists(lists[start], lists[end]);
        }
        //超过两个节点
        else {
          int mid = (start + end) / 2;
             ListNode left = mergeKLists(lists, start, mid);
             ListNode right = mergeKLists(lists, mid+1, end);
         return mergeTwoLists(left, right);
        }
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode dummy = new ListNode();
        ListNode l1Ptr = l1;
        ListNode l2Ptr = l2;
        ListNode dummyPtr = dummy;

        while (l1Ptr != null && l2Ptr != null){
            //L1节点比较小
            if (l1Ptr.val <= l2Ptr.val){
                dummyPtr.next = l1Ptr;

                dummyPtr = dummyPtr.next;
                l1Ptr = l1Ptr.next;
            } else{
                dummyPtr.next = l2Ptr;
                dummyPtr = dummyPtr.next;
                l2Ptr = l2Ptr.next;
            }
        }

        if (l1Ptr != null){
            dummyPtr.next = l1Ptr;
        }

        if (l2Ptr != null){
            dummyPtr.next = l2Ptr;
        }

        return dummy.next;
    }
}
