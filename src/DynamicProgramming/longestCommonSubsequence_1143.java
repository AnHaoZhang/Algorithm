package DynamicProgramming;

/**
 * @author cbz
 * @version 1.0
 */
public class longestCommonSubsequence_1143 {
    public static int longestCommonSubsequence(String text1, String text2) {
        char[] s = text1.toCharArray(), t = text2.toCharArray();
        int n = s.length, m = t.length;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                f[i + 1][j + 1] = s[i] == t[j] ? f[i][j] + 1 :
                        Math.max(f[i][j + 1], f[i + 1][j]);
            }
        }
        return f[n][m];

    }

    public static void main(String[] args) {
//        "abcde";"ace"; "ezupkr" "ubmrapg"

        String text1 = "oxcpqrsvwf";
        String text2 = "shmtulqrypy";
//        String text1 ="bsbininm";
//        String text2 = "jmjkbkjkv";
        System.out.println(longestCommonSubsequence(text1,text2));
    }

}
