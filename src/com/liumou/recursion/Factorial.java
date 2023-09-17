package com.liumou.recursion;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class Factorial {
    //利用递归求阶乘
    public static int f(int n) {
        if (n == 1) return 1;
        return n * f(n - 1);
    }

    /**
     * 利用递归反向打印字符串
     */

    public void f1(int n, String str) {
        if (n == str.length()) {
            return;
        }
        f1(n + 1, str);
        System.out.println(str.charAt(n));
    }

    /**
     * 利用递归求解二分查找
     */
    //对外函数
    public static int search(int[] a, int target) {
        return f(a, target, 0, a.length - 1);
    }

    //对内
    private static int f(int a[], int target, int i, int j) {
        if (i > j) return -1;
        int m = (i + j) >>> 1;
        if (a[m] < target) {
            return f(a, target, m + 1, j);
        } else if (target < a[m]) {
            return f(a, target, i, m - 1);
        } else {
            return m;
        }
    }


    /**
     * 递归冒泡排序
     *
     * @param a
     * @param j
     */
    //对内
    private static void bubble(int[] a, int j) {
        if (j == 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            if (a[i] > a[i + 1]) {
                int t = a[i];
                a[i] = a[i + 1];
                a[i + 1] = t;
            }
            x = i;
        }
        bubble(a, x);
    }

    //对外
    public static void sort(int[] a) {
        bubble(a, a.length - 1);
    }


    /**
     * 插入排序
     */
    public static void sort2(int[] a){
        insertion(a,1);
    }

    private static void insertion(int[] a, int low) {
        if (low == a.length ){
            return;
        }
        //low表示未排序区左边界
        int t = a[low];
        int i = a[low - 1];

        while (i >= 0 && a[i] > t) {
            a[i + 1] = a[i];
            i--;
        }

        a[i + 1] = t;

        insertion(a, low + 1);
    }

    /**
     * 尾调用，如果函数的最后一步是调用一个函数，则称为尾调用，比如 return b();
     */
    //有些编译器可以对其进行优化


    /**
     * 多路递归经典问题之-----汉诺塔
     */


}
