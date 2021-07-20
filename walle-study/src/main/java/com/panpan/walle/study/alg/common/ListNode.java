package com.panpan.walle.study.alg.common;


import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 构造列表
     *
     * @param nodes
     * @return
     */
    public static ListNode buildList(List<Integer> nodes){
        ListNode dummyNode = new ListNode();
        ListNode currNode = dummyNode;

        for (Integer i : nodes){
            ListNode newNode = new ListNode(i);
            currNode.next = newNode;
            currNode = currNode.next;
        }

        return dummyNode.next;
    }

    /**
     * 打印链表
     */
    public static void printListNode(ListNode head){
        System.out.println("======== listNode 数据 =========");
        ListNode curr = head;
        while (curr != null){
            System.out.printf("%d ", curr.val);
            curr = curr.next;
        }
    }
}

