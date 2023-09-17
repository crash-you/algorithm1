package com.liumou.recursion;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class HanoiTower {
    /**
     * 用linklist代表柱子
     */

    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    /**
     * @param n 圆盘
     * @param a 原柱子
     * @param b 借的柱子
     * @param c 目标柱子
     */
    static void move(int n, LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c) {
        if(n == 0){
            return;
        }
        move(n-1,a,c,b);
        c.addLast(a.removeLast());
        extracted();
        System.out.println("--------------------------");
        move(n-1,b,a,c);
    }

    public void init(int n) {
        for (int i = n; i >= 1; i--) {
            a.addLast(i);
        }
    }


    @Test
    public void test_init(){
        HanoiTower x = new HanoiTower();
        x.init(16);
        extracted();
        System.out.println("------------------");
        move(16,a,b,c);
    }

    private static void extracted() {
        System.out.println(HanoiTower.a);
        System.out.println(HanoiTower.b);
        System.out.println(HanoiTower.c);
    }
}
