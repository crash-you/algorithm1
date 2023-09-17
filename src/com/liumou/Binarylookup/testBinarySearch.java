package com.liumou.Binarylookup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.liumou.Binarylookup.myBinarySearch.BinarySearchBasic;

public class testBinarySearch {

    @Test
    @DisplayName("测试BinarySearch 找到")
    public void test1() {
        int[] a = {7, 31, 68, 99, 102, 888, 920};
        Assertions.assertEquals(0, BinarySearchBasic(a, 7));
    }

    @Test
    @DisplayName("java版二分查找")
    public void test2() {
        int[] a = {2, 5, 8, 9};
        int target = 6;

        int i = Arrays.binarySearch(a, target);
        //返回值i ->  i =  -插入点 - 1
        //插入点是如果此没有找到的元素要插入到数组中的索引位置
        System.out.println(i);

        if (i < 0) {
            //数学函数，abs表示取绝对值
            int insertIndex = Math.abs(i + 1);
            int[] b = new int[a.length + 1];
            //参数含义，
            //第一个参数 -- 要拷贝的数组
            //第二个参数 -- 从哪个索引开始拷贝
            //第三个参数 -- 要拷贝到哪个数组的名称
            //第四个参数 -- 拷贝长度
            System.arraycopy(a,0,b,0,insertIndex);
            b[insertIndex] = target ;
            System.arraycopy(a,insertIndex,b,insertIndex+1,a.length-insertIndex);
            System.out.println(Arrays.toString(b));
        }

    }

    @Test
    public void test(){
        int a = 10/3;
        System.out.println(a);
    }



}
