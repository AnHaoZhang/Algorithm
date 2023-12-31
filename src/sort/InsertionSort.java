package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author cbz
 * @version 1.0
 * 插入排序
 */
public class InsertionSort {
    //插入排序
    public static void insertionSort(int[] arr) {
        //1、从1开始，遍历数组
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i], j = i;
            //从后往前遍历
            while (j > 0 && val < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            //插入
            arr[j] = val;
        }
    }
    public static void main(String[] args) {

        System.out.println("请输入数组长度");
        Scanner scanner = new Scanner(System.in);//从键盘接收数据
        int n = scanner.nextInt();
        int[] arr=new int[n];
        System.out.println("请输入数组");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
        scanner.close();
    }
}
