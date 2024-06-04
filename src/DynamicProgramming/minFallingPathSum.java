package DynamicProgramming;

import java.util.Arrays;

/**
 * @author cbz
 * @version 1.0
 */
public class minFallingPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        System.arraycopy(matrix[0], 0, dp[0], 0, n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int mn = dp[i - 1][j];
                if (j > 0) {
                    mn = Math.min(mn, dp[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    mn = Math.min(mn, dp[i - 1][j + 1]);
                }
                dp[i][j] = mn + matrix[i][j];
            }
        }
        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4}, {7,8,9}};
        int i = minFallingPathSum(matrix);
        System.out.println(i);
    }
}
