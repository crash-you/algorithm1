package com.liumou.linklist.E01Leetcode;

import java.util.Arrays;

public class E01Merge2StoredArray {
    //合并两个有序数组
    //方法一：递归
    /*
    merge([1,2,4,6] [2,6,9] a2 = []){
        merge([2,4,6] [2,6,9] a2 = [1]){
            merge([4,6] [2,6,9] a2 = [1,2]){
                merge([4,6] [6,9] a2 = [1,2,2]){
                    merge([6] [6,9] a2 = [1,2,2,4]){
                        merge([] [6,9] a2 = [1,2,2,4,6]){
                            merge([] [] a2 = [1,2,2,4,6,6,9])
                        }
                    }
                }
            }
        }
    }
     */
    public void merge(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2, int k) {
        if (i > iEnd) {
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
            return;
        }
        if (j > jEnd) {
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
            return;
        }
        if (a1[i] < a1[j]) {
            a2[k] = a1[i];
            merge(a1, i + 1, iEnd, j, jEnd, a2, k + 1);
        } else {
            a2[k] = a1[j];
            merge(a1, i, iEnd, j + 1, jEnd, a2, k + 1);
        }
    }


    public static void main(String[] args) {
        int[] a1 = {1,2,4,3,6,7,11};
        int[] a2 = new int[a1.length];
        E01Merge2StoredArray e01Merge2StoredArray = new E01Merge2StoredArray();
        e01Merge2StoredArray.merge(a1,0,2,3,6,a2,0);
        System.out.println(Arrays.toString(a2));
    }
}
