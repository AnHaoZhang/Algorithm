package DynamicProgramming;

/**
 * @author cbz
 * @version 1.0
 */

import java.util.Arrays;

/**
 * 338. 比特位计数
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 */
public class countBits_338 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int n = 10;
        System.out.println(Arrays.toString(countBits(n)));
    }

    /**
     * 1、定义子问题：求 i中二进制1的个数
     * 2. 推导状态转移方程：若i为偶数则1的个数为 i/2 这个数中二进制1的个数ans[i] = ans[i / 2]；
     *    若i为奇数则1的个数为 i/2 这个数中二进制1的个数+1 ans[i] = ans[i / 2] + 1;
     * 3. 确定初始条件和边界条件： ans[0] = 0 ,0中二进制没有1;从0开始小于等于传入的数n
     * 4. 计算顺序：0——>n
     * 5. 优化空间复杂度（可选）：
     */
    public static int[] countBits(int n){
        // 创建一个长度为 n+1 的数组 ans，用于存储每个数字的二进制表示中 1 的个数
        int[] ans = new int[n + 1];
        // 从 0 到 n 遍历每个数字
        for (int i = 0; i <= n; i++) {
            // 如果 i 是偶数，则 ans[i] 等于 ans[i/2]
            if (i % 2 == 0) {
                ans[i] = ans[i / 2];
            } else {
                // 如果 i 是奇数，则 ans[i] 等于 ans[i/2] + 1
                ans[i] = ans[i / 2] + 1;
            }
        }
        // 返回计算得到的数组 ans
        return ans;
    }

    public static int[] countBits1(int n) {
        // 创建一个数组用于存储结果
        int[] ans = new int[n + 1];
        // 初始情况
        ans[0] = 0;
        // 从 1 到 n 逐个计算每个数字的二进制表示中 1 的个数
        for (int i = 1; i <= n; i++) {
            // 如果 i 是偶数，则 i 的二进制中 1 的个数和 i/2 相同
            // 如果 i 是奇数，则 i 的二进制中 1 的个数比 i/2 多一个（因为 i 是 i/2 左移一位后再加 1）
            ans[i] = ans[i >> 1] + (i & 1); /** 重点*/
        }
        // 返回结果数组
        return ans;
    }
}
