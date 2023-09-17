package com.liumou.linklist.E01Leetcode;

public class E01Leetcode876 {
    /**
     * 876. 链表的中间结点:给你单链表的头结点 head ，请你找出并返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     */

    //快慢指针法，定义两个指针，每次一个走一步另一个走两部，这样快指针永远是慢指针的二倍
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null & p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
            p2 = p2.next;
        }
        return p1;
    }
}
