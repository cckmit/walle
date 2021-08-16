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
     * 生成随机列表
     *
     * @param len
     * @param maxValue 最大值
     * @return
     */
    public static ListNode generateRandomLinkedList(int len, int maxValue) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        ListNode head = new ListNode((int) (Math.random() * (maxValue + 1)));
        ListNode pre = head;
        while (size != 0) {
            ListNode cur = new ListNode((int) (Math.random() * (maxValue + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
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

