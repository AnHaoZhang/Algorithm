package sort;

/**
 * @author cbz
 * @version 1.0
 * 基数排序
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//基数排序
public class RadixSort {
    public static void radixSort(int[] arr) {
        //获取数组长度
        if (arr.length < 2) return;
        //求出最大值
        int maxVal = arr[0];
        for (int a : arr) {
            if (maxVal < a) {
                maxVal = a;
            }
        }
        //获取最大值位数
        int n = 1;
        //求出最大值位数
        while (maxVal / 10 != 0) {
            //除以10
            maxVal /= 10;
            n++;
        }

        for (int i = 0; i < n; i++) {
            List<List<Integer>> radix = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                //初始化
                radix.add(new ArrayList<>());
            }
            int index;
            for (int a : arr) {
                //获取最大值
                index = (a / (int) Math.pow(10, i)) % 10;
                radix.get(index).add(a);
            }
            index = 0;
            for (List<Integer> list : radix) {
                for (int a : list) {
                    arr[index++] = a;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组长度");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("请输入数组");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
        scanner.close();
    }
}

