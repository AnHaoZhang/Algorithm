package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author cbz
 * @version 1.0
 */
public class findLongestChain_646 {

    public static int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[][] a = {{1,2}, {2, 3}, {3, 4}};
        System.out.println(findLongestChain(a));
    }
}
