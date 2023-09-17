package com.liumou.linklist.E01Leetcode;

public class DeleteElement {

    /**
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     * @param value
     * @param head
     * @return
     */
    //方法一，带哨兵删除
    public ListNode removeElements(int value,ListNode head){
        if(head == null) return null;
        ListNode s = new ListNode(-1,head);
        ListNode p1 = s;
        ListNode p2 = p1.next;
        while (p2 != null){
            if(p2.value == value){
                p1.next = p2.next;
            }else {
                p1 = p1.next;
            }
            p2 = p1.next;
        }
        return s.next;
    }

    //改动后代码
    public ListNode removeElements02(int value,ListNode head){
        if(head == null) return null;
        ListNode s = new ListNode(-1,head);
        ListNode p1 = s;
        ListNode p2;               //1
        while ((p2=p1.next) != null){       //2
            if(p2.value == value){
                p1.next = p2.next;
            }else {
                p1 = p1.next;
            }
                                //3
        }
        return s.next;
    }


    //方法二：递归解
    public ListNode removeElements1(int value,ListNode head){
        if(head == null){
            return null;
        }
        if(head.value == value){
            return removeElements1(value,head.next);
        }else {
            head.next = removeElements1(value,head.next);
            return head;
        }
    }




}
