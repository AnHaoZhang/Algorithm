package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author cbz
 * @version 1.0
 */
public class HeapSort {
        private static int heapLen;

        public static void heapSort(int[] arr) {
            heapLen = arr.length;
            for (int i = heapLen - 1; i >= 0; i--) {
                heapify(arr, i);
            }

            for (int i = heapLen - 1; i > 0; i--) {
                swap(arr, 0, heapLen - 1);
                heapLen--;
                heapify(arr, 0);
            }
        }

        private static void heapify(int[] arr, int idx) {
            int left = idx * 2 + 1, right = idx * 2 + 2, largest = idx;
            if (left < heapLen && arr[left] > arr[largest]) {
                largest = left;
            }
            if (right < heapLen && arr[right] > arr[largest]) {
                largest = right;
            }

            if (largest != idx) {
                swap(arr, largest, idx);
                heapify(arr, largest);
            }
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
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
