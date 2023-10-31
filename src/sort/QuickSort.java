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
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIdx = partition(arr, left, right);
            sort(arr, 0, pivotIdx - 1);
            sort(arr, pivotIdx + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int idx = left + 1;
        for (int i = idx; i <= right; i++) {
            if (arr[left] > arr[i]) {
                swap(arr, i, idx++);
            }
        }
        swap(arr, left, idx - 1);
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
    }
}

