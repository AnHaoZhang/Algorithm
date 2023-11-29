package DynamicProgramming;

/**
 * @author cbz
 * @version 1.0
 */
public class jump {
    public int jump(int[] nums) {

        int n = nums.length;
        //定义dp数组，dp[i]表示从nums[0]到nums[i]的最小跳跃次数
        int[] dp = new int[n];
        dp[0] = 0;
        //初始化dp数组
        for (int i = 1; i < n; i++) {
            //初始化dp数组的值为最大值
            dp[i] = Integer.MAX_VALUE;

            for (int j = 0; j < i; j++) {
                //判断从nums[0]到nums[i]的最小跳跃次数
                if (j + nums[j] >= i) {
                    //如果从nums[0]到nums[i]的最小跳跃次数小于dp[i],则更新dp[i]
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new jump().jump(nums));
    }
}
