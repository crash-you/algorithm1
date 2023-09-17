package com.liumou.linklist.E01Leetcode;

public class ListNode {

    int value;
    ListNode next;


    public ListNode() {
    }

    public ListNode(int value) {
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }


    public String toString() {
        return "ListNode{value = " + value + ", next = " + next + "}";
    }
}
