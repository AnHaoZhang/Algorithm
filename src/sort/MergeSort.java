package sort;

/**
 * @author cbz
 * @version 1.0
 * 归并排序
 */
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static int[] mergeSort(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return arr;
        }
        //递归分解
        int mIdx = len / 2;
        //分解
        return merge(mergeSort(Arrays.copyOfRange(arr, 0, mIdx)), mergeSort(Arrays.copyOfRange(arr, mIdx, len)));
    }

    private static int[] merge(int[] arrLeft, int[] arrRight) {
        //合并
        int leftLen = arrLeft.length, rightLen = arrRight.length, leftIdx = 0, rightIdx = 0, idx = 0;
        //初始化结果数组
        int[] result = new int[leftLen + rightLen];
        //合并
        while (leftIdx < leftLen && rightIdx < rightLen) {
            //比较
            if (arrLeft[leftIdx] < arrRight[rightIdx]) {
                result[idx++] = arrLeft[leftIdx++];
            } else {
                result[idx++] = arrRight[rightIdx++];
            }
        }
        //合并
        while (leftIdx < leftLen) {
            result[idx++] = arrLeft[leftIdx++];
        }
        //合并
        while (rightIdx < rightLen) {
            result[idx++] = arrRight[rightIdx++];
        }
        return result;
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
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        scanner.close();
    }
}

