/**
 * @author cbz
 * @version 1.0
 */
public class Main {
        public static void main(String[] args) {
            int n = 1213545653;
            System.out.println(tribonacci(n));
        }
        private static int tribonacci(int n) {
            int num = 1000000007;
            long[] dp = new long[n+1];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int i = 4; i <= n;i++){
                dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % num;
            }
            return (int)dp[n];
        }
}


