package com.liumou.linklist.E01Leetcode;

public class E03Leercode19 {
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     */

    //解法一：递归
    public ListNode removeElement(int n, ListNode head) {
        ListNode s = new ListNode(-1, head);
        recursion(n, s);
        return s.next;
    }

    private int recursion(int n, ListNode head) {
        if (head == null) {
            return 0;
        }
        int rec = recursion(n, head.next);      //下一个节点是倒数第几个节点
        if (rec == n) {
            head.next = head.next.next;         //如果等于，则删除上一个节点
        }
        return rec + 1;                           //返回当前节点是第几个节点
    }

    /**
     * 方法二：前后指针法
     *     核心思想，设置两个指针，将一个指针先移动n+1个单位，
     *     再将两个指针依次向前移动直到先移动的那个指针指向null，此时后移动的指针的下一个就是待删除元素
     */

    public ListNode removeNthFromEnd(int n, ListNode head) {
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2 = s;
        for (int i = 0; i < n + 1; i++) {
            p2 = p2.next;
        }
        while (p2!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return s.next;
    }

}
