package PracticeOnceaday;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author cbz
 * @version 1.0
 */
public class closeStrings1657 {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String word1 = "cabbba";
        String word2 = "abbccc";
        System.out.println(closeStrings(word1, word2));
    }

    /**
     * 1. 首先判断两个字符串长度是否相等
     * 2. 其次判断word1中字符数量与word2中字符数量是否相等
     * @param word1
     * @param word2
     * @return
     */
    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        // 将字符串的字符添加到对应的 Set 中
        for (char c : word1.toCharArray()) {
            set1.add(c);
        }

        for (char c : word2.toCharArray()) {
            set2.add(c);
        }
        // 比较两个 Set 是否相等
        if (!set1.equals(set2)){
            return false;
        }


        int[][] dp = new int[26][2];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
            dp[i][1] = 0;
        }
        for (char c : word1.toCharArray()) {
            dp[c - 'a'][1]++;
        }
        for (char c : word2.toCharArray()) {
            dp[c - 'a'][1]--;
        }

        int count = 0;
        for (int i = 0; i < dp.length; i++) {
//            if(dp[i][1] > 0){
//
//            }
//                char a  = (char) (dp[i][0]+'a');
//                int n = dp[i][1];
//                if (n < -1 || n > 1) {
//                    return false;
//                }
//                System.out.println("a = " + a +"n = " + n);

            count += dp[i][1];
        }
        if (count != 0) {
            return false;
        }
        return true;
    }
}
