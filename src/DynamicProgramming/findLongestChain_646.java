package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author cbz
 * @version 1.0
 */
public class findLongestChain_646 {

    public static int findLongestChain(int[][] pairs) {
        // 获取输入数组的长度
        int n = pairs.length;

        // 对 pairs 数组进行排序，按每个子数组的第一个元素升序排列
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0]; // 以每个对的第一个元素进行比较和排序
            }
        });

        // 创建 dp 数组，初始化每个位置的值为 1，因为每个位置最少可以自己形成一个链
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        // 双重循环遍历每一个对，寻找可以连接的最长链
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 如果当前对的第一个元素大于前一个对的第二个元素，表示可以形成链
                if (pairs[i][0] > pairs[j][1]) {
                    // 更新 dp[i] 的值，取当前值和 dp[j] + 1 的最大值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 返回 dp 数组的最后一个元素，即最长的链
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[][] a = {{1,2}, {2, 3}, {3, 4}};
        System.out.println(findLongestChain(a));
    }
}
