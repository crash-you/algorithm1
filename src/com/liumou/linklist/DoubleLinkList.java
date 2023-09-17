package com.liumou.linklist;

import java.util.Iterator;

//双向链表，带哨兵
public class DoubleLinkList implements Iterable<Integer> {

    static class Node {
        Node pre;
        int value;
        Node next;

        public Node(Node pre, int value, Node next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;  //头哨兵
    private Node tail;  //尾哨兵

    public void DoubleLinkListSentinel() {
        head = new Node(null, 666, null);
        tail = new Node(null, 666, null);
        head.next = tail;
        tail.pre = head;
    }

    public Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != tail; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    public void addFirst(int value) {
        insert(value, 0);
    }

    public void insert(int value, int index) {
        Node pre1 = findNode(index - 1);
        if (pre1 == null) throw getIllegalArgumentException(index);
        Node next1 = pre1.next;
        Node inserted = new Node(pre1, value, next1);
        pre1.next = inserted;
        next1.pre = inserted;
    }

    public void remove(int index) {
        Node prev = findNode(index - 1);
        if(prev == null){
            throw getIllegalArgumentException(index);
        }
        Node removed = prev.next;
        if(removed == tail){
            throw getIllegalArgumentException(index);
        }
        Node next1 = removed.next;
        prev.next = next1;
        next1.pre = prev;
    }

    public void addLast(int value){
        Node pre = tail.pre;
        Node node = new Node(tail.pre, value, tail);
        pre.next = node;
        tail.pre = node;
    }

    public void removeLast(){
        Node removed = tail.pre;
        if(removed == head){
            throw getIllegalArgumentException(0);
        }
        Node pre = removed.pre;
        pre.next = tail;
        tail.pre = pre;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                 return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;

            }
        };
    }

    private static IllegalArgumentException getIllegalArgumentException(int index) {
        return new IllegalArgumentException(
                String.format("index[d%]不合法", index)
        );
    }

}
