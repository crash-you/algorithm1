package com.liumou.recursion;

import org.junit.jupiter.api.Test;

public class R01Fibonacci {

    //利用递归求斐波那契额数列第n项值
    private static int f(int n) {
        if (n == 0) return 0;
        else if (n == 1) {
            return 1;
        }
        return f(n - 1) + f(n - 2);
    }
    public static int searchFi(int n){
        int f = f(n);
        System.out.println(f);
        return f;
    }


    //斐波那契变式，不死神兔问题
    //描述：每只兔子都会在第二个月开始每个月诞生一个兔子，初始时有一只兔子，求第n个月之后的兔子
    public int q(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return q(n - 1) + q( n - 2);
    }

    //斐波那契优化，记忆法，定义一个一维数组存储每次求得的斐波那契的值
    public static int searchFi2(int n){
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        int f = f2(n,cache);
        System.out.println(f);
        return f;
    }

    private static int f2(int n,int[] cache) {
        if(cache[n] != -1){
            return cache[n];
        }

        cache[n] = f2(n-1,cache) + f2(n-2,cache);

        return cache[n];
    }


}
