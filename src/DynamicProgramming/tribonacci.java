package DynamicProgramming;

/**
 * @author cbz
 * @version 1.0
 */
public class tribonacci {
    public static int tribonacci(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 1;
//        }
//        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        int[] dp = new int[n+1];
        int i;
        dp[0] = 0;dp[1] = 1;dp[2] = 1;
        for(i = 3;i <= n; i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(4));
    }
}
