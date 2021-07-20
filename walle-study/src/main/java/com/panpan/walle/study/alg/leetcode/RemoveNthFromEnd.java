package com.panpan.walle.study.alg.leetcode;

import com.panpan.walle.study.alg.common.ListNode;

import java.util.Arrays;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode listNode = ListNode.buildList(Arrays.asList(1,2,3,4,5,6,7,8));
        listNode = removeNthFromEnd(listNode, 5);
        ListNode.printListNode(listNode);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null || n < 0){
            return head;
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        ListNode first = head;
        ListNode second = dummyNode;//n-1

        while (n-- > 0 && first != null){
            first = first.next;
        }

        //链表长度不够N
        if (n > 0 ){
            return head;
        }

        while (first != null){
            first = first.next;
            second = second.next;
        }

        //链表删除
        second.next = second.next.next;

        return dummyNode.next;
    }
}
