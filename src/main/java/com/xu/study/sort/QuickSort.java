package com.xu.study.sort;

import com.xu.study.sort.util.SortUtil;

/**
 * @Description  快速排序实现
 * @Author xgx
 * @Date 2019/11/27 10:47
 */
public class QuickSort {

    public static void  partition(int []arr, int left, int right){

        int mid = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (arr[j] > mid && i < j) j --;
            arr[i] = arr[j];
            while (arr[i] <= mid && i < j) i ++;
            arr[j] = arr[i];
        }
        int psition = i;
        arr[psition] = mid;

        if (i-1 > left)
            partition(arr, left, psition-1);
        if (j+1 < right)
            partition(arr, psition+1, right);
    }

    public static void main(String[] args) {
        int []arr = new int[]{5, 3, 7, 6, 4, 1, 0, 2, 9, 10, 8};
        System.out.print("原始数据：");
        SortUtil.print(arr);
        partition(arr,0, arr.length-1);
        System.out.print("最终数据：");
        SortUtil.print(arr);
    }
}

/**
 * 递归三要素：
 * 1. 一定有一种可以退出程序的情况；
 *  例如本实例中，当排序切割到最小单元时候（两个元素），临界条件是i-1 > left 和 j+1 < right
 * 2. 总是在尝试将一个问题化简到更小的规模
 * 3. 父问题与子问题不能有重叠的部分
 */
