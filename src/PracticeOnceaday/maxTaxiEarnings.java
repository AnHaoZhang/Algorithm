package PracticeOnceaday;

/**
 * @author cbz
 * @version 1.0
 */
public class maxTaxiEarnings {

    public static void main(String[] args) {
        int[][] rides = {{2,5,4},{1,5,1}};
        int n = 5;
        System.out.println(new maxTaxiEarnings().maxTaxiEarnings(n, rides));

    }

    public long maxTaxiEarnings(int n, int[][] rides) {
        int r = rides.length; //行
        int c = rides[0].length; //列
        System.out.println("r="+r+" c="+c);
        int max = 0;
        int[] dp = new int[r];
//        for (int i = 0; i < r; i++) {
//            dp[i] = rides[i][1] - rides[i][0] + rides[i][2];
//        }
        for (int i = 0; i < r; i++) {
            for (int j = 1; j < r; j++) {
                if (rides[j][0] <= rides[i][0] && rides[i][0] <= rides[j][1]) {
                    dp[i] = Math.max(rides[i][1] - rides[i][0] + rides[i][2], rides[j][1] - rides[j][0] + rides[j][2]);
                    System.out.println("dp"+dp[i]);
                }
            }

        }

        return 0;
    }
}
