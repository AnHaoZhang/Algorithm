package DynamicProgramming;

import java.util.Scanner;

/**
 * @author cbz
 * @version 1.0
 */
public class climbStairs_70 {
    /**
     * 70. 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 示例 1：
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     *
     * 示例 2：
     * 输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
     */
    /**
     * 1. 定义子问题
     * 子问题是求解到达第 i 级台阶的方法数。
     * 用 dp[i] 表示到达第 i 级台阶的方法数。
     * 2. 写出子问题的递推关系
     * 到达第 i 级台阶的方法数等于到达第 i-1 级台阶的方法数加上到达第 i-2 级台阶的方法数。因为每次只能爬 1 级或 2 级台阶。
     * 递推关系：dp[i] = dp[i - 1] + dp[i - 2]
     * 3. 确定 DP 数组（表）的计算顺序
     * 我们需要从小到大计算每个 dp[i]。
     * 计算顺序是从 dp[1] 开始，直到 dp[n]。
     * 4. 确定初始条件和边界条件
     * 初始条件是到达第 1 级台阶和第 2 级台阶的方法数。
     * dp[1] = 1（只有一种方法到达第 1 级台阶）
     * dp[2] = 2（有两种方法到达第 2 级台阶：一次爬两级或两次各爬一级）
     * 边界条件是处理 n 为 1 的情况，直接返回 1。或者边界条件是处理 n 为 小于等于2 的情况，直接返回 n
     * 5. 计算结果
     * 通过从 dp[3] 到 dp[n] 的计算，最终得到 dp[n]，即到达第 n 级台阶的方法数
     */

    // 方案一
    public static int climbStairs(int n) {
        // 边界条件判断
        if (n == 1) {
            return 1;
        }
        // 创建动态规划数组 创建一个整型数组 dp，长度为 n + 1，用于存储到达每一级台阶的方法数。
        int[] dp = new int[n + 1];
        // 初始化前两级台阶的方法数
        dp[1] = 1;
        dp[2] = 2;
        // 从第三级台阶开始，计算到达每一级台阶的方法数
        for (int i = 3; i <= n; i++) {
            // 到达第 i 级台阶的方法数等于到达第 i-1 级台阶和第 i-2 级台阶的方法数之和
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // 返回到达第 n 级台阶的方法数
        return dp[n];
    }

    // 方案二
    public static int climbStairs2(int n) {
        // 边界条件判断
        if (n <= 2) {
            return n;
        }
        // 创建动态规划数组 创建一个整型数组 dp，长度为 n + 1，用于存储到达每一级台阶的方法数。
        int[] dp = new int[n + 1];
        //初始化前两级台阶的方法数
        dp[1] = 1;
        dp[2] = 2;
        // 从第三级台阶开始，计算到达每一级台阶的方法数
        for (int i = 3; i <= n; i++) {
            // 到达第 i 级台阶的方法数等于到达第 i-1 级台阶和第 i-2 级台阶的方法数之和
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // 返回到达第 n 级台阶的方法数
        return dp[n];
    }

    /**
     * 定义子问题：dp[i] 表示到达第 i 级台阶的方法数。
     * 递推关系：dp[i] = dp[i - 1] + dp[i - 2]
     * 计算顺序：从 dp[1] 到 dp[n] 逐步计算。
     * 初始条件：
     * dp[1] = 1
     * dp[2] = 2
     * 计算结果：dp[n] 表示到达第 n 级台阶的方法数。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(climbStairs2(n));
    }
}
