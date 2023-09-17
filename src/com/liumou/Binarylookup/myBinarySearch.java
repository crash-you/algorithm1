package com.liumou.Binarylookup;

public class myBinarySearch {

    /**
     * 二分查找基础版
     * Params:
     * a--待查找的升序数组
     * target--待查找的目标值
     * Returns:
     * 找到则返回索引找不到返回-1
     */
    public static int BinarySearchBasic(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;

        while (i <= j) {
            int m = (i + j) >>> 2; //java语言两个整数除法自动取整
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }


        }

        return -1;
    }

    /**
     * 以上代码问题
     * (i + j) / 2 可能会存在数组越界问题
     * 解决方案
     * >>> 运算符：不带符号右移运算（十进制中没有负号）
     * 底层：二进制右移
     * 偶数 右移一位十进制中除以二 eg：8 >>> 1 -> 4  二进制解释：0000 1000 >>> 1 -> 0000 0100 ->4
     * 奇数 右移一位十进制中除以二向下取整 eg: 7 >>> 1 -> 3
     * >> 运算符：带符号右移运算
     */


    /**
     * 二分查找改动版
     *
     * @param a
     * @param target
     * @return
     */
    public static int BinarySearchAlternative(int[] a, int target) {
        int i = 0;
        int j = a.length; //第一处改动，j指向的一定不是查找目标

        while (i < j) {    //第二处改动
            int m = (i + j) >>> 2;
            if (target < a[m]) {
                j = m;    //第三处改动
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    /**
     * 二分查找平衡版
     *
     * @param a
     * @param target
     * @return
     */
    //由于之前版本有多个if，导致左右比较不平衡，所以衍生了此版本
    public static int BinarySearchBalance(int[] a, int target) {

        int i = 0;
        int j = a.length;

        while (1 < j - i) {
            int m = (j + i) >>> 1;
            if (target < a[m]) {
                j = m;
            } else {
                i = m;
            }
        }

        if (a[i] == target) {
            return i;
        }

        return -1;
    }

    /**
     * java版本的二分查找Arrays.binarySearch(参数)
     */

    /**
     * 二分查找最左侧版（有多个重复元素出现时）
     *
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchLeftMost(int[] a, int target) {

        int i = 0;
        int j = a.length - 1;
        int candidate = -1;

        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (a[mid] < target) {
                i = mid + 1;
            } else if (target < a[mid]) {
                j = mid - 1;
            } else {
                //纪律候选位置
                candidate = mid;
                j = mid - 1;
            }
        }
        return candidate;
    }

    /**
     * 二分查找最左侧改动返回值版（有多个重复元素出现时）此时返回值代表>=target的最靠左索引
     *
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchLeftMost1(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;

        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (a[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        //i代表>=target的最靠左索引
        return i;
    }

    /**
     * 二分查找最右侧版（有多个元素出现时）
     *
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchRightMost(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        int candidate = -1;

        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (a[mid] < target) {
                i = mid + 1;
            } else if (target < a[mid]) {
                j = mid - 1;
            } else {
                //纪律候选位置
                candidate = mid;
                i = mid + 1;
            }
        }
        return candidate;
    }

    /**
     * 二分查找最右侧改动返回值版（有多个重复元素出现时）此时返回值代表 <= target的最靠右索引
     *
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchRightMost1(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;

        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (a[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        //i代表>=target的最靠左索引
        return i - 1;
    }

}
