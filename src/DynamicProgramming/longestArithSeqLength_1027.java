package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cbz
 * @version 1.0
 */
public class longestArithSeqLength_1027 {
    public static int longestArithSeqLength(int[] nums) {
        /**
         1、定义子问题  0-i 的等差序列
         2、状态转移方程 dp[i，d] = dp[i-1] +1;
         3、初始和边界条件
         4、计算顺序
         */
        /**
         * 方案一：
         */
//        int n = nums.length; // 获取数组的长度
//        Map<Integer, Integer>[] f = new Map[n]; // 创建一个Map数组，数组的每个元素是一个Map，用于存储以该元素结尾的等差序列的长度
//        for (int i = 0; i < n; i++) {
//            f[i] = new HashMap<>(); // 初始化每个Map
//        }
//        int res = 0; // 结果变量，用于存储最长的等差序列的长度
//        for (int i = 1; i < n; i++) { // 遍历数组的每一个元素，从第二个元素开始
//            for (int j = 0; j < i; j++) { // 遍历当前元素之前的所有元素
//                int d = nums[i] - nums[j]; // 计算当前元素和之前元素的差值
//                if (f[j].containsKey(d)) { // 如果之前的元素中存在以差值d为公差的等差序列
//                    f[i].put(d, Math.max(f[i].getOrDefault(d, 0), f[j].get(d) + 1)); // 更新当前元素的Map，等差序列长度加1
//                } else {
//                    f[i].put(d, Math.max(f[i].getOrDefault(d, 0), 2)); // 如果之前元素中不存在以d为公差的等差序列，初始化为2
//                }
//                res = Math.max(res, f[i].get(d)); // 更新结果
//            }
//        }
//        return res; // 返回最长的等差序列的长度

        int minv = Arrays.stream(nums).min().getAsInt(); // 找到数组中的最小值
        int maxv = Arrays.stream(nums).max().getAsInt(); // 找到数组中的最大值
        int diff = maxv - minv; // 计算数组中的最大差值
        int ans = 1; // 初始化答案为1，因为单个元素也是一个长度为1的等差数列

        // 遍历所有可能的差值d，从-diff到+diff
        for (int d = -diff; d <= diff; ++d) {
            int[] f = new int[maxv + 1]; // 创建一个长度为maxv + 1的数组，用于记录以每个数为结尾的最长等差数列的长度
            Arrays.fill(f, -1); // 初始化数组，所有值设为-1，表示尚未计算

            // 遍历数组中的每个数
            for (int num : nums) {
                int prev = num - d; // 计算前一个数
                // 检查前一个数是否在[minv, maxv]范围内且已经计算过
                if (prev >= minv && prev <= maxv && f[prev] != -1) {
                    // 如果满足条件，更新当前数为结尾的等差数列长度
                    f[num] = Math.max(f[num], f[prev] + 1);
                    ans = Math.max(ans, f[num]); // 更新答案
                }
                f[num] = Math.max(f[num], 1); // 确保当前数至少有一个长度为1的等差数列
            }
        }
        return ans; // 返回最长等差数列的长度



    }

    public static void main(String[] args) {
        int[] nums = {3,6,9,12};
        System.out.println(longestArithSeqLength(nums));
    }
}
