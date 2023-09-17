package com.liumou.linklist;

import java.util.function.Consumer;

//此为有哨兵节点的情形下
public class SingleLinkList2 {
    //单向链表
    private int i1 = 0;
    private Node head = new Node(i1,null);

    //节点类
    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    //头插法
    public void addFirst(int value) {
        //链表为空
        //  head = new Node(value, null);
        //链表不为空
        head.next = new Node(value, head);                      //改动一
    }

    //遍历链表
    public void loop1(Consumer<Integer> consumer) {
        Node p = head;
        while (p.next != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head; p.next != null; p = p.next) {
            System.out.println(p.value);
        }
    }

    /**
     * 尾插法
     *
     * @return
     */
    private Node findLast() {
        Node p;
        for (p = head; p.next != null; p = p.next) ;
        return p;
    }

    public void addLast(int value) {
        Node last = findLast();
        last.next = new Node(value, null);
    }

    //根据索引找数据
    private Node findNode(int index) {
        Node p;
        int i = 0;
        for (p = head.next; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw getIllegalArgumentException(index);
        }
        return node.value;

    }

    private static IllegalArgumentException getIllegalArgumentException(int index) {
        return new IllegalArgumentException(
                String.format("index[d%]不合法", index)
        );
    }

    public void insert(int index, int value) {

        if(index == 0){
            addFirst(value);
            return;
        }

        Node previous = findNode(index - 1);

        if (previous == null){
            throw getIllegalArgumentException(index);
        }

        previous.next = new Node(value, previous.next);

    }

    public void removeFirst(){
        if(head == null){
            throw getIllegalArgumentException(0);
        }
        head = head.next;
    }

    public void remove(int index){

        if(index == 0){
            removeFirst();
            return;
        }

        Node previous = findNode(index - 1);
        if(previous == null) getIllegalArgumentException(index);
    //    previous.next = previous.next.next;  //这里不能.next.next直接指向，因为在Java虚拟机中，只有不被引用的对象才会被释放
        Node removed = previous.next;
        if(removed == null){
            throw getIllegalArgumentException(index);
        }
        previous.next = removed.next;

    }

}

