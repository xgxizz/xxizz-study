package com.xu.study.sort;

import com.xu.study.sort.util.SortUtil;

/**
 * @Description 归并排序实现
 * 归并排序采用的是分治法思想。
 * 基本思想：将待排序元素分成大小大致相同的2个子集合，分别对2个子集合进行排序，最终将排好序的子集合合并成为所要求的排好序的集合。
 * @Author xgx
 * @Date 2019/11/27 15:18
 */
public class MergeSort {

    /**
     * @Description  合并两个有序数组
     * @Author xgx
     * @Date 2019/11/27 17:02
     * @Param [arr 待排序数组 left 数组最左侧下标 mid  中间元素坐标 right数组最右侧坐标 tmp  临时数组]
     * @return void
     */
    public static void merge(int []arr, int left, int mid, int right, int []tmp){

        int i = 0;
        int j = left;
        int k = mid + 1;
        while(j<=mid && k <=right){
            if (arr[j] < arr[k]){
                tmp[i++] = arr[j++];
            }else{
                tmp[i++] = arr[k++];
            }
        }
        //若左边序列还有剩余，则将其全部拷贝进tmp[]中
        while (j<=mid){
            tmp[i++] = arr[j++];
        }
        //若右边序列还有剩余，则将其全部拷贝进tmp[]中
        while (k<=right){
            tmp[i++] = arr[k++];
        }
        for (int t = 0; t < i ; t++) {
            arr[left+t] = tmp[t];
        }
    }
    /**
     * @Description  归并排序递归算法
     * @Author xgx
     * @Date 2019/11/27 17:24
     * @Param [arr, left, right, tmp]
     * @return void
     */
    public static void mergeSort(int []arr, int left, int right, int []tmp){
        int mid = (left + right)/2;
        if (left < right){
            mergeSort(arr, left, mid, tmp);
            mergeSort(arr,mid+1, right, tmp);
            merge(arr, left, mid, right, tmp);
        }
    }
    
    public static void main(String[] args) {
        int []arr = new int[]{5, 3, 7, 6, 4, 1, 0, 2, 9, 10, 8};
        int []tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, tmp);
        SortUtil.print(arr);
    }
}
