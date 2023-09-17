package com.liumou.recursion;

/**
 * 杨辉三角
 */
public class PascalTriangle {
    public static int element(int i, int j) {
        if(j == 0 || i == j){
            return 1;
        }
        return element(i - 1, j) + element(i - 1, j - 1);
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
        for (int i = 0; i < n; i++) {
            printSpace(n,i);
            for (int j = 0; j <= i ; j++) {
                System.out.printf("%-6d" , element(i,j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
   //     System.out.println(element(4, 2));
        print(8);
    }

}
