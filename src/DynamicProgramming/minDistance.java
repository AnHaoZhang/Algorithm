package DynamicProgramming;

import java.util.Scanner;

/**
 * @author cbz
 * @version 1.0
 */
public class minDistance {
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m  = word2.length();

        if(n*m == 0){
            return n+m;
        }

        int[][] D = new int[n+1][m+1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return D[n][m];
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入字符串：");
//        String s = scanner.nextLine(); // 读取整行文本
        String word1 = "horse";
        String word2 = "ros";

        System.out.println(minDistance(word1,word2));
//        scanner.close();
    }
}
