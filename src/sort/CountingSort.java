package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author cbz
 * @version 1.0
 * 计数排序
 */
public class CountingSort {
    public static void countingSort(int[] arr) {
        //获取数组长度
        int len = arr.length;
        if (len < 2) return;
        //1.获取最大值和最小值
        int minVal = arr[0], maxVal = arr[0];
        //遍历数组
        for (int i = 1; i < len; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            } else if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        //2. 创建初始化一个计数数组（counting array），长度为`max - min + 1`
        int[] countArr = new int[maxVal - minVal + 1];

        //3.遍历待排序数组，统计每个元素出现次数
        for (int val : arr) {
            countArr[val - minVal]++;
        }

        //4.根据计数数组生成已排序数组
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
        scanner.close();


    }

}

