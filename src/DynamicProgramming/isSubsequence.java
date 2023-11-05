package DynamicProgramming;

/**
 * @author cbz
 * @version 1.0
 */
public class isSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0,j = 0;
        // i表示s的下标，j表示t的下标
        while (i < s.length() && j < t.length()) {
            // 比较两个字符是否相等
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        isSubsequence isSub = new isSubsequence();
        System.out.println(isSub.isSubsequence(s, t));
    }
}
