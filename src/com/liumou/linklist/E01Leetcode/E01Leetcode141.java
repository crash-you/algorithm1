package com.liumou.linklist.E01Leetcode;

/**
 * 检测链表是否有环
 */
public class E01Leetcode141 {
   /*
   给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
    为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
    如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
    */

    /*弗洛伊德龟兔判断算法
    采用龟兔赛跑算法实现
    阶段一：
    乌龟一次走一步，兔子一次走两步
    当兔子能走到终点，则无环
    当乌龟能追上兔子，则有环

    阶段二：判断环的入口位置
    当他们第一次相遇开始，乌龟回到起点，兔子保持原位置不变
    兔子和龟一次都走一步
    再次相遇时的位置即为环的入口位置
     */

    public boolean hasCycle(ListNode head) {
        ListNode h = head;//兔子
        ListNode t = head;//乌龟
        while (h != null && h.next != null) {
            h = h.next.next;
            t = t.next;
            if (h == t){
                return false;
            }
        }
        return true;
    }
}
