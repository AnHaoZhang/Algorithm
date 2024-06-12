package DynamicProgramming;

/**
 * @author cbz
 * @version 1.0
 */
public class lengthOfLIS_300 {
    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列
     *
     * 示例 1：
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：[1,1,4,3,3,2,1,1]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 示例 2：
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     * 示例 3：
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     */
    public static int lengthOfLIS(int[] nums) {
        // 如果数组为空，返回0，因为没有上升子序列
        if (nums.length == 0) {
            return 0;
        }
        // 创建一个dp数组，dp[i]表示以nums[i]结尾的最长上升子序列的长度
        int[] dp = new int[nums.length];
        // 初始化dp数组的第一个元素，长度为1，因为以第一个元素结尾的子序列只有它自己
        dp[0] = 1;
        // 初始化最大长度的变量，初始值为1
        int maxans = 1;
        // 从第二个元素开始遍历数组
        for (int i = 1; i < nums.length; i++) {
            // 初始化dp[i]为1，因为以nums[i]结尾的最短子序列是它自己
            dp[i] = 1;
            // 遍历nums[0]到nums[i-1]的元素，寻找比nums[i]小的元素
            for (int j = 0; j < i; j++) {
                // 如果nums[i]大于nums[j]，说明可以形成上升子序列
                if (nums[i] > nums[j]) {
                    // 更新dp[i]，选择dp[j] + 1和当前dp[i]的最大值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 更新最大长度
            maxans = Math.max(maxans, dp[i]);
        }
        // 返回最长上升子序列的长度
        return maxans;
    }
    public static void main(String[] args) {
//        int[] nums = {0,1,0,3,3,3};
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {1,3,5,4,7};
        System.out.println(lengthOfLIS(nums));
    }
}
