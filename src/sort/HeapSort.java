package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author cbz
 * @version 1.0
 * 堆排序
 */
public class HeapSort {
        private static int heapLen;

        public static void heapSort(int[] arr) {
            heapLen = arr.length;
            // 1、构建大顶堆
            for (int i = heapLen - 1; i >= 0; i--) {
                heapify(arr, i);
            }
            // 2、交换堆顶元素与末尾元素
            for (int i = heapLen - 1; i > 0; i--) {
                swap(arr, 0, heapLen - 1);
                heapLen--;
                heapify(arr, 0);
            }
        }
        // 3、用于将数组构建成最大堆或重新堆化的辅助方法
        private static void heapify(int[] arr, int idx) {
            int left = idx * 2 + 1, right = idx * 2 + 2, largest = idx;
            // 1、比较左右子节点的大小
            if (left < heapLen && arr[left] > arr[largest]) {
                largest = left;
            }
            // 2、比较左右子节点的大小
            if (right < heapLen && arr[right] > arr[largest]) {
                largest = right;
            }
            // 3、如果子节点不是最大堆顶元素、交换它们，并继续递归堆化
            if (largest != idx) {
                swap(arr, largest, idx);
                heapify(arr, largest);
            }
        }
        // 4、交换堆顶元素与末尾元素
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
        scanner.close();
    }

}
