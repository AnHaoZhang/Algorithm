package DynamicProgramming;

/**
 * @author cbz
 * @version 1.0
 */
public class findNumberOfLIS_673 {
    /**
     * 673. 最长递增子序列的个数
     * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
     * 注意 这个数列必须是 严格 递增的。
     *
     * 示例 1:
     * 输入: [1,3,5,4,7]
     * 1,2,3,3,4
     * 1,1,1,1,2
     * 输出: 2
     * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
     * 示例 2:
     * 输入: [2,2,2,2,2]
     * 输出: 5
     * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
     */
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length, maxLen = 0, ans = 0; // n为数组长度，maxLen存储最长上升子序列的长度，ans存储最长上升子序列的个数
        int[] dp = new int[n]; // dp[i]表示以nums[i]结尾的最长上升子序列的长度
        int[] cnt = new int[n]; // cnt[i]表示以nums[i]结尾的最长上升子序列的个数

        // 遍历数组中的每个元素
        for (int i = 0; i < n; ++i) {
            dp[i] = 1; // 初始化dp[i]为1，因为以nums[i]结尾的子序列最短为1
            cnt[i] = 1; // 初始化cnt[i]为1，因为以nums[i]结尾的子序列至少有1个

            // 遍历nums[0]到nums[i-1]
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) { // 如果nums[i]大于nums[j]，说明可以形成上升子序列
                    if (dp[j] + 1 > dp[i]) { // 检查是否可以形成更长的上升子序列
                        dp[i] = dp[j] + 1; // 更新dp[i]为更长的上升子序列长度
                        cnt[i] = cnt[j]; // 重置计数为cnt[j]，因为发现了更长的上升子序列
                    } else if (dp[j] + 1 == dp[i]) { // 如果形成的上升子序列长度相同
                        cnt[i] += cnt[j]; // 增加计数，因为有多种途径形成相同长度的上升子序列
                    }
                }
            }
            // 更新maxLen和ans
            if (dp[i] > maxLen) {
                maxLen = dp[i]; // 更新最长上升子序列的长度
                ans = cnt[i]; // 重置计数
            } else if (dp[i] == maxLen) {
                ans += cnt[i]; // 增加计数，因为发现了相同长度的上升子序列
            }
        }
        // 返回最长上升子序列的个数
        return ans;

        /**
         * dp[j] + 1 > dp[i] 的作用和意义如下：
         * 作用：
         * 这一条件用来判断是否能通过 nums[i] 和 nums[j] 形成一个新的、更长的上升子序列。如果可以形成更长的上升子序列，则更新 dp[i] 和 cnt[i] 的值。
         * 意义：
         * 在动态规划算法中，dp[i] 表示以 nums[i] 结尾的最长上升子序列的长度。而 dp[j] 表示以 nums[j] 结尾的最长上升子序列的长度。
         * 如果 nums[i] > nums[j]，表示 nums[i] 可以接在 nums[j] 后面形成一个上升子序列。此时，如果 dp[j] + 1 > dp[i]，
         * 说明以 nums[j] 结尾的上升子序列加上 nums[i] 形成的子序列比当前已知的以 nums[i] 结尾的最长子序列还要长，因此需要更新 dp[i]。
         *
         * 详细解释：
         * dp[j] + 1 表示如果把 nums[i] 接到以 nums[j] 结尾的最长上升子序列后面的长度。
         * dp[i] 当前以 nums[i] 结尾的最长上升子序列的长度。
         * 如果 dp[j] + 1 > dp[i]，说明以 nums[j] 结尾的上升子序列加上 nums[i] 会形成一个比当前已知的以 nums[i] 结尾的最长上升子序列更长的新子序列，所以需要更新 dp[i] 和 cnt[i]。
         */
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(findNumberOfLIS(nums));
    }
}
