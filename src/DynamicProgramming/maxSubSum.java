package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author cbz
 * @version 1.0
 */
public class maxSubSum {
    /**
     * 求解思路：用sum(j)表示a1到aj的和，很容易求出动态规划的递归式：
     *  sum(j) = max(sum(j-1)+aj , aj)
     * 时间复杂度：O(N)
     * 动态规划的好处在于，能很清楚的返回最佳连续子序列和的起始位置和终点位置
     *
     */
    public static int maxSubSum5(int[] a) {
        int maxSum = 0;
        int tempSum = 0;
        int begin = 0;

        for (int i = 0; i < a.length; i++) {
            if (tempSum > 0)
                tempSum += a[i];
            else {
                tempSum = a[i];
                begin = i;  //标记
            }

            if (tempSum > maxSum) {
                maxSum = tempSum;
                //可以在这里获取最佳连续子序列和的起点位置begin和重点位置i
            }

        }
        return maxSum;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        int[] a = { 1, -3, 7, 8, -4, 12, -10, 6 };
        System.out.println("请输入数组长度");
        Scanner scanner = new Scanner(System.in);//从键盘接收数据
        int n = scanner.nextInt();
        int[] arr=new int[n];
        System.out.println("请输入数组");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("第五种动态规划方法：" + maxSubSum5(arr));
    }
}
