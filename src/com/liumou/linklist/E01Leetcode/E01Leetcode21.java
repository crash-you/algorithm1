package com.liumou.linklist.E01Leetcode;

public class E01Leetcode21 {
    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */

//    /方法一：双指针法+哨兵法
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode s = new ListNode(-1, null);
        ListNode p = s;
        ListNode p1 = list1;
        ListNode p2 = list2;

        while (p1 != null && p2 != null) {
            if (p1.value < p2.value) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return s.next;

    }

    //方法二：递归法
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }

        if (list1.value < list2.value){
            list1.next = mergeTwoLists1(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeTwoLists1(list1,list2.next);
            return list2;
        }
    }

}
