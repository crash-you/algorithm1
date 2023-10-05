package com.liumou.linklist.E01Leetcode;

/**
 * 检测链表是否有环并返回环的位置
 */

public class E01Leetcode142 {
    public ListNode detectCycle(ListNode head) {
        ListNode t = head; //乌龟
        ListNode h = head; //兔子
        while (h != null && h.next != null){
            t = t.next;
            h = h.next.next;
            if (h == t){
                return findOriginal(head, h);
            }
        }
        return null;
    }

    private static ListNode findOriginal(ListNode head , ListNode x){
        ListNode t1 = head;
        ListNode h1 = x;
        while (t1 != h1){
            t1 = t1.next;
            h1 = h1.next;
        }
        return h1;
    }
}
