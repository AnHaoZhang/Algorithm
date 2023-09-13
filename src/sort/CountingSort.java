package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author cbz
 * @version 1.0
 */
public class CountingSort {
    public static void countingSort(int[] arr) {
        int len = arr.length;
        if (len < 2) return;
        int minVal = arr[0], maxVal = arr[0];
        for (int i = 1; i < len; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            } else if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }

        int[] countArr = new int[maxVal - minVal + 1];
        for (int val : arr) {
            countArr[val - minVal]++;
        }
        for (int arrIdx = 0, countIdx = 0; countIdx < countArr.length; countIdx++) {
            while (countArr[countIdx]-- > 0) {
                arr[arrIdx++] = minVal + countIdx;
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
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

