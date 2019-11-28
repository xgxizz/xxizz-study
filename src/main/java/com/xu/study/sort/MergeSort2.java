package com.xu.study.sort;

import com.xu.study.sort.util.SortUtil;

/**
 * @Description
 * @Author xgx
 * @Date 2019/11/27 17:52
 */
public class MergeSort2 {

    public static void merge(int []arr, int left, int right, int mid){

        int i = 0;//tmp数组的指针下标
       int []tmp = new int[arr.length];
       int j = left;
        int k = mid + 1;
        while (j<=mid && k <= right) {
            if (arr[j] <= arr[k]){
                tmp[i++] = arr[j++];
            }else{
                tmp[i++] = arr[k++];
            }
        }
        while (j <=mid) tmp[i++] = arr[j++];
        while (k <= right) tmp[i++] = arr[k++];

        for (int t = 0; t < i; t++) {
            arr[t+left] = tmp[t];
        }
    }

    public static void mergeSort(int []arr, int left, int right){

        int mid = (left + right) / 2;
        if (left<right) {
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            //合并
            merge(arr, left, right, mid);
        }
    }
    public static void main(String[] args) {
        int []arr = new int[]{5, 3, 7, 6, 4, 1, 0, 2, 9, 10, 8};
        mergeSort(arr, 0, arr.length-1);
        SortUtil.print(arr);
    }
}
