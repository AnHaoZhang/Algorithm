package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author cbz
 * @version 1.0
 * 快速排序
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        // 调用快速排序算法，传入数组，数组的长度，以及数组的起始索引
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left < right) {
            // 1、选取基准值
            int pivotIdx = partition(arr, left, right);
            // 2、递归排序左右子数组
            sort(arr, 0, pivotIdx - 1);
            sort(arr, pivotIdx + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int idx = left + 1;// 初始化索引 i 为 -1
        // 从左往右遍历数组，找出小于 arr[left] 的数，放在左边，大于 arr[left] 的数放在右边
        for (int i = idx; i <= right; i++) {
            if (arr[left] > arr[i]) {
                // 交换
                swap(arr, i, idx++);
            }
        }
        swap(arr, left, idx - 1);
        // 返回中轴索引
        return idx - 1;
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
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
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
        scanner.close();
    }
}

