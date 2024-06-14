package DynamicProgramming;

/**
 * @author cbz
 * @version 1.0
 */
public class canjump_55 {
    /**
     * 55. 跳跃游戏
     *
     * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
     *
     * 示例 1：
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     *
     * 示例 2：
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     * @param args
     */
    public static void main(String[] args) {
//        int[] arr = {2, 3, 1, 1, 4};
        int[] arr = {2,0,0};
        System.out.println(canJump(arr));
    }

    public static boolean canJump(int[] arr) {
        int n = arr.length;  // 获取数组长度
        boolean[] dp = new boolean[n];  // 创建一个布尔数组 dp，长度为 n
        dp[0] = true;  // 初始位置肯定是可以到达的

        // 从位置 1 开始遍历到最后一个位置
        for (int i = 1; i < n; i++) {
            // 检查之前的位置 j 能否跳到当前位置 i
            for (int j = 0; j < i; j++) {
                // 如果位置 j 可以到达，并且从位置 j 可以跳到位置 i
                if (dp[j] && j + arr[j] >= i) {
                    dp[i] = true;  // 当前位置 i 也可以到达
                    break;  // 跳出内层循环
                }
            }
        }

        // 返回最后一个位置是否可以到达
        return dp[n - 1];
    }

}
