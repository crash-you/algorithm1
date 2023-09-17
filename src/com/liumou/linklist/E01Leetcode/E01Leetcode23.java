package com.liumou.linklist.E01Leetcode;

public class E01Leetcode23 {
    /**
     * 23. 合并 K 个升序链表
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     */

    //递归解决，利用二叉树思想解决！
    public ListNode mergeKLists(ListNode[] lists) {
        return split(lists, 0, lists.length - 1);
    }
    /**
     * 递归思想：分而治之（divide and conquer） (分，治，合)
     * 分--把一个问题拆分成多个子问题
     * 治--缩小到最后可以解决问题
     * 合--将最后的多个子问题结果合并在一起
     * 减而治之--没有多路递归 ，例子--递归实现二分查找
     */
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

    private ListNode split(ListNode[] lists, int i, int j) {
        if (i == j){    //数组内只有一个元素
         return lists[i];
        }
        int m = (i + j) >>> 1;
        ListNode left = split(lists, i, m);
        ListNode right = split(lists, m + 1, j);
        return mergeTwoLists(left,right);           //想象为一个二叉树去思考！
    }
}
