package com.liumou.linklist.E01Leetcode;

public class E01Leetcode234 {
    /**
     * 234. 回文链表:给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     */

    //步骤一：寻找中间节点
    //步骤二：中间点后半段链表反转
    //步骤三：反转后链表与原链表逐一比较
    public boolean isPalindrome(ListNode head){
        ListNode middle = middle(head);
        ListNode reserve = reserve(middle);
        while (reserve != null){
            if (reserve.value != head.value){
                return false;
            }
            head = head.next;
            reserve  = reserve.next;
        }
        return true;
    }

    private ListNode middle(ListNode head){
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next !=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    private ListNode reserve(ListNode middle){
        if (middle.next == null || middle ==null){
            return middle;
        }
        ListNode last = reserve(middle.next);
        middle.next.next = middle;
        middle.next = null;
        return last;
    }

    //旧方法时间复杂度过于高，现在新方法
    //在找到中间点的同时将前边半段链表反转
    public boolean isPalindrome1(ListNode head){
//        ListNode p1 = head;
//        ListNode p2 = head;
//        while (p2 != null && p2.next !=null){
//            p1 = p1.next;
//            p2 = p2.next.next;
//        }
//        ListNode middle = p1;
//
//
//        ListNode reserve;
//        if (middle.next == null || middle ==null){
//            reserve = middle;
//        } else {
//            ListNode last = reserve(middle.next);
//            middle.next.next = middle;
//            middle.next = null;
//            reserve = last;
//        }
//        while (reserve != null){
//            if (reserve.value != head.value){
//                return false;
//            }
//            head = head.next;
//            reserve  = reserve.next;
//        }

        ListNode p1 = head;  //慢指针
        ListNode p2 = head; //快指针、
        ListNode o1 = head; //旧指针
        ListNode n1 = null;  //新指针
        while (p2 != null && p2.next !=null){
            p1 = p1.next;
            p2 = p2.next.next;

            //反转链表
            //这里o2 = o1.next 和p1 的移动轨迹相同，所以 o2 就是 p1 ，此时o2 可以删除
//            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = p1;
        }
        //此时这个方法问题是如果 元素为奇数个 ，会报错 如 1 2 2 2 1 ，原因为 快慢指针中，奇数个时后半段为 2 2 1 ，这时需要向前移动一个指针
        //此时有规律，当为奇数个时，p2（快指针）的最后一位总是为null，根据此判断
        if (p2!= null){
            p1 = p1.next;
        }
        while ( n1 != null){
            if (n1.value != p1.value){
                return false;
            }
            n1 = n1.next;
            p1 = p1.next;
        }

        return true;
    }

}
