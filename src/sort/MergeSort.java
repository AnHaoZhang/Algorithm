package sort;

/**
 * @author cbz
 * @version 1.0
 */
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static int[] mergeSort(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return arr;
        }

        int mIdx = len / 2;
        return merge(mergeSort(Arrays.copyOfRange(arr, 0, mIdx)), mergeSort(Arrays.copyOfRange(arr, mIdx, len)));
    }

    private static int[] merge(int[] arrLeft, int[] arrRight) {
        int leftLen = arrLeft.length, rightLen = arrRight.length, leftIdx = 0, rightIdx = 0, idx = 0;
        int[] result = new int[leftLen + rightLen];
        while (leftIdx < leftLen && rightIdx < rightLen) {
            if (arrLeft[leftIdx] < arrRight[rightIdx]) {
                result[idx++] = arrLeft[leftIdx++];
            } else {
                result[idx++] = arrRight[rightIdx++];
            }
        }
        while (leftIdx < leftLen) {
            result[idx++] = arrLeft[leftIdx++];
        }
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
    }
}

