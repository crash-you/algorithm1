package com.liumou.linklist.E01Leetcode;

public class E01Leetcode83 {
    /**
     * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
     */

    //方法一：双指针法
    public ListNode deleteDuplicates(ListNode head){
        //判断临界值
        if(head == null || head.next == null){
            return head;
        }
        ListNode p1 = head;
        ListNode p2;
        while ((p2 = p1.next) != null){
            if(p1.value == p2.value){
                p1.next = p2.next;
            }else {
                p1 = p1.next;
            }
        }
        return head;
    }

    //方法二：递归解
    public ListNode deleteDuplicates1(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        if(head.value == head.next.value){
            return deleteDuplicates1(head.next);
        }else {
            head.next = deleteDuplicates1(head.next);
            return head;
        }
    }
}
