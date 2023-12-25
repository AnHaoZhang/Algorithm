package DynamicProgramming;

/**
 * @author cbz
 * @version 1.0
 */
public class numDecodings {
    public static void main(String[] args) {
        String s="12320421";
        System.out.println(new numDecodings().numDecodings(s));

    }
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n + 1];
        for (int i = 0;i <= n-1;i++){
            dp[i] = s.charAt(i);
            System.out.println("dp[i]="+dp[i]);
        }

        return 0;
    }
}
