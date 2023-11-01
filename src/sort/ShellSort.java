package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author cbz
 * @version 1.0
 * 希尔排序
 */
public class ShellSort {
    public static void shellSort(int[] arr) {
        int len = arr.length, tmp, j;
        // 初始间隔为数组长度的一半，然后逐渐减小间隔
        for (int gap = len / 2; gap >= 1; gap = gap / 2) {
            // 从第gap个元素,逐个对其所在的组进行直接插入排序
            for (int i = gap; i < len; i++) {
                tmp = arr[i];
                j = i - gap;
                // 从第j个元素开始向前搜索插入的位置
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
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
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
        scanner.close();
    }
}
