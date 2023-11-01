package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author cbz
 * @version 1.0
 * 选择排序
 */
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int len = arr.length;
        //1、遍历数组
        for (int i = 0; i < len - 1; i++) {
            int minVal = i;
            for (int j = i + 1; j < len; j++) {
                //2、比较，找出最小值
                if (arr[minVal] > arr[j]) {
                    minVal = j;
                }
            }
            //3、交换
            if (minVal != i) {
                int tmp = arr[i];
                arr[i] = arr[minVal];
                arr[minVal] = tmp;
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
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        scanner.close();
    }
}
