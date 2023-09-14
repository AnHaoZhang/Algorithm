package Searching;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author cbz
 * @version 1.0
 * 二分查找
 */
public class Binarylookup {

    /**
     * 递归二分查找法
     * @param arr 数组
     * @param key 目标值
     * @param low 最小值数组下标
     * @param hight 最大值数组下标
     * @return 目标值数组下标
     *
     */
    public static int recursionBinarySearch(int arr[],int key,int low,int hight){
        if(key < arr[low] || key > arr[hight] || low > hight){
            return -1;
        }

        int middle = (low + hight) / 2;			//初始中间位置
        if(arr[middle] > key){
            //比关键字大则关键字在左区域
            return recursionBinarySearch(arr, key, low, middle - 1);
        }else if(arr[middle] < key){
            //比关键字小则关键字在右区域
            return recursionBinarySearch(arr, key, middle + 1, hight);
        }else {
            System.out.println("key所在数组的下标是"+middle+"数值是："+arr[middle]);
            return middle;
        }
    }

    /**
     * 不使用递归的二分查找
     *title:commonBinarySearch
     *@param arr
     *@param key
     *@return 关键字位置
     */
    public static int commonBinarySearch(int[] arr,int key){
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;			//定义middle

        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }

        while(low <= high){
            middle = (low + high) / 2;
            if(arr[middle] > key){
                //比关键字大则关键字在左区域
                high = middle - 1;
            }else if(arr[middle] < key){
                //比关键字小则关键字在右区域
                low = middle + 1;
            }else{
                System.out.println("key所在数组的下标是"+middle+"数值是："+arr[middle]);
                return middle;
            }
        }

        return -1;		//最后仍然没有找到，则返回-1
    }

    public static void main(String[] args) {

        System.out.println("请输入数组长度");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr=new int[n];
        System.out.println("请输入要查找的key");
        Scanner scan = new Scanner(System.in);
        int key = scan.nextInt();
        System.out.println("请输入数组");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

//        recursionBinarySearch(arr,key,0,n-1);

        commonBinarySearch(arr,key);
    }

}
