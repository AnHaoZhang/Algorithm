package DynamicProgramming;

/**
 * @author cbz
 * @version 1.0
 */
public class massage {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(tribonacci(nums));
    }

    public static int tribonacci(int[] nums) {
        int i;
        if(nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }else{
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[i-1];
        }
    }

}
