package com.liumou.recursion;

public class PascalTriangle2 {
    /**
     * 记忆法优化杨辉三角
     */

    public static int element(int [][] cache,int i, int j) {
        if(cache[i][j] > 0){
            return cache[i][j];
        }
        if(j == 0 || i == j){
            cache[i][j] = 1;
            return 1;
        }
        cache[i][j] = element(cache,i - 1, j) + element(cache,i - 1, j - 1);
        return cache[i][j];
    }

    //打印空格
    private static void printSpace(int n, int i){
        int num = (n-1- i) * 3;
        for (int j = 0; j < num; j++) {
            System.out.print(" ");
        }
    }

    //n代表杨辉三角的高度
    public static void print(int n){
        int[][] cache= new int [n][];
        for (int i = 0; i < n; i++) {
            cache[i] = new int[i+1];
            printSpace(n,i);
            for (int j = 0; j <= i ; j++) {
                System.out.printf("%-6d" , element(cache,i,j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //     System.out.println(element(4, 2));
        print(8);
    }
}
