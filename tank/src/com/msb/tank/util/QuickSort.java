package com.msb.tank.util;

/**
 * @description :快排
 * @author：jty
 * @date: 2020-10-28
 * @sine: 0.0.1
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
        quicksort(arr, 0, arr.length-1);
        System.out.println("排序后：");
        for (int i : arr){
            System.out.println(i);
        }
    }

    private static void quicksort(int[] arr, int low, int high){
        if (low < high){
            //找寻基础数据的正确索引
            int index = getIndex(arr, low, high);

            //进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            quicksort(arr, low, index -1);
            quicksort(arr, index +1, high);
        }
    }

    private static int getIndex(int[] arr, int low, int high){
        //基准数据
        int tmp = arr[low];
        while (low < high){
            //当队尾的元素大于等于基准数据时，向前挪动high指针
            while (low < high && arr[high] >= tmp){
                high--;
            }
            //如果队尾元素小于tmp了，需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时，向前挪动low指针
            while (low < high && arr[low] <= tmp){
                low++;
            }
            arr[high] = arr[low];
        }
        //跳出循环时low和high相等，此时的low或high就是tmp的正确索引位置
        //由原理部分可以很清楚的知道low位置的值并不是tmp，所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low;//返回tmp的正确位置
    }
}
