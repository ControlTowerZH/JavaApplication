package com.hao.javalib.sort;

import java.util.Arrays;

public class TestQuickSort {

    public static void main(String[] args) {
        //给出无序数组
        int aar[]={72,6,57,88,60,42,84,73,48,85};
        //输出无序数组
        System.out.println(Arrays.toString(aar));
        //进行快速排序
        quickSort(aar);
        //partition(aar,0,aar.length-1);
        //输出有序数组
        System.out.println(Arrays.toString(aar));


    }

    private static void quickSort(int[] aar) {
         int low=0;
         int  high=aar.length-1;
         quickSort(low,high,aar);
    }

    private static void quickSort(int low, int high, int[] arr) {
        if (low<high) {
            //分区操作，将数组分成两个区，返回分区界限索引
            int index = partition(arr, low, high);
            //对左分区进行快速排序
            quickSort(low, index - 1, arr);
            //对右分区进行快速排序
            quickSort(index + 1, high, arr);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        //指定左指针i 和右指针j
        int i = low;
        int j = high;
        //将第一个值作为基准值，挖坑
        int x = arr[low];
        //使用循环进行分区操作
        while (i<j){
            //1.从右向左移动j,找到第一个小于基准值的值 arr[j]
            while (arr[j]>=x && i<j){
                j--;
            }

            //2.将右侧找到小于基准数的值加入到左边的坑位置，左指针向中间移动一个位置 i++
            if (i<j){
                arr[i]=arr[j];
                i++;
            }
            //3.从左向右移动i，找到第一个大于等于基准值的值arr[i]
            while (arr[i]<x && i<j){
                i++;
            }
            //4.将左侧找到的打印等于基准值的值加入到右边的坑中，右指针向中间移动一个位置 j--
            if (i<j){
                arr[j]=arr[i];
                j--;
            }

        }


        //使用基准值填坑，确定了基准值的最终位置
        arr[i]=x;
        //返回基准值的位置索引
        return i;
    }

}
