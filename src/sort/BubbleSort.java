package sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author cbz
 * @version 1.0
 * 冒泡排序算法
 */

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        /* 获取传入数组长度*/
        int len = arr.length;
        /* 遍历次数*/
        for (int i = 0; i < len - 1; i++) {
            /* 声明退出标志 */
            boolean flag = true;
            /* 3.一个数遍历完成*/
            for (int j = 0; j < len - i - 1; j++) {
                /* 1.比较相邻的元素*/
                if (arr[j] < arr[j + 1]) {
                    /* 2.交换，按从大到小排序*/
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    /* 交换标志*/
                    flag = false;
                }
            }
            /* 退出循环*/
            if (flag) {
                break;
            }
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
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        scanner.close();
    }
}
