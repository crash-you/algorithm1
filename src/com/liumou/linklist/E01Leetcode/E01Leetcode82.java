package com.liumou.linklist.E01Leetcode;

public class E01Leetcode82 {
    /**
     * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     */
    //方法一：三指针法,加哨兵
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2;
        ListNode p3;
        while ((p2 = p1.next) != null && (p3 = p2.next) != null) {
            if (p2.value == p3.value) {
                while ((p3 = p3.next) !=null && (p3.value == p2.value)){
                }
                p1.next = p3;
            } else {
                p1 = p1.next;
            }
        }
        return s.next;
    }

    //方法二：递归
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.value == head.next.value) {
            ListNode x = head.next.next;
            while (x != null && x.value == head.value) {
                x = x.next;
            }
            return deleteDuplicates1(x);
        } else {
            head.next = deleteDuplicates1(head.next);
            return head;
        }
    }

}
