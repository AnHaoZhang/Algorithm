package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
  * @author cbz
  * @version 1.0
  */
public class getMaximumGenerated {

    public static int getMaximumGenerated(int n) {

        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int i;
        for (i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i / 2] + dp[i / 2 + 1];
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(getMaximumGenerated.getMaximumGenerated(i));
    }
}
