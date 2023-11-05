package DynamicProgramming;

/**
 * @author cbz
 * @version 1.0
 */
public class minCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
/**
 * 1、暴力破解法
 */
        int n = cost.length;
        int [] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            if (dp[i - 1] >= dp[i - 2]) {
                dp[i] = dp[i - 2] + cost[i];
            }else {
                dp[i] = dp[i - 1] + cost[i];
            }
        }

        return Math.min(dp[n - 1], dp[n - 2]);

    }

    public static void main(String[] args) {
        minCostClimbingStairs minCostClimbingStairs = new minCostClimbingStairs();
        int[] cost = {0,1,2,2};
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(cost));
    }
}
