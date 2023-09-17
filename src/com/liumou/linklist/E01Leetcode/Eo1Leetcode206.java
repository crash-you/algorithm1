package com.liumou.linklist.E01Leetcode;

import com.liumou.recursion.HanoiTower;

/**
 * 反转链表
 */

public class Eo1Leetcode206 {
    //  方法1:构建新链表，遍历旧链表插入到新链表中
    public ListNode reverseList(ListNode o1){

        ListNode n1 = null;
        ListNode p = o1;
        while (p!=null){
            n1 = new ListNode(p.value, n1);
            p = p.next;
        }
        return n1;
    }

    //方法二：构建新链表，从旧链表头部移除节点，添加到新链表头部,完成后的新链表是倒叙的，
    //      区别在于原题未提供节点的容器类。这里提供一个，另外一个区别是并不去构造新的节点
    public ListNode reverseList1(ListNode head){
        List list1 = new List(head);
        List list2 = new List(null);
        while (true){
            ListNode listNode = list1.removeFirst();
            if(listNode == null){
                break;
            }
            list2.addFirst(listNode);
        }
        return list2.head;
    }

    static class List{
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode first){
            first.next = head;
            head = first;
        }

        public ListNode removeFirst(){
            ListNode first = head;
            if (first!=null){
                head = first.next;
            }
            return first;
        }
    }

    //方法三：结合递归
     public ListNode reverseList2(ListNode p){
        if(p.next == null || p == null){
            return p;
        }
        ListNode last = reverseList2(p.next);
        p.next.next = p;
        p.next = null;
        return last;
     }

     //方法四：双指针法:从链表中每次拿到第二个节点，将其从链表中断开，插入头部，直至他为null结束
    public ListNode reverseList3(ListNode o1){
        if(o1 == null || o1.next == null){
            return null;
        }
        ListNode old2 = o1.next;//旧指针
        ListNode new1 = o1;     //新指针
        while (old2 != null){
            o1.next = old2.next; //将旧指针断开，即将o1指针指向旧指针下一元素
            old2.next = new1;    //o2节点链入头部
            new1 = old2;         //n1-》o2
            old2 = o1.next;      //o2指向o1的下一个节点
        }
        return new1;
    }

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5,null);
        ListNode o4 = new ListNode(4,o5);
        ListNode o3 = new ListNode(3,o4);
        ListNode o2 = new ListNode(2,o3);
        ListNode o1 = new ListNode(1,o2);
        System.out.println(o1);
        ListNode n1 = new Eo1Leetcode206().reverseList2(o1);
        System.out.println(n1);
    }


}
