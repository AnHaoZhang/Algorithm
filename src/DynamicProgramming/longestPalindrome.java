package DynamicProgramming;

/**
 * @author cbz
 * @version 1.0
 */
public class longestPalindrome {
    public static void main(String[] args) {
        String s = "aaabaaaa";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        /**
         * 1、字符串只有1个直接返回
         * 2.字符串长度大于等于2
         *  2.1判断第一个与最后一个相不相等，相等则判断i+1与j-1个相不相等，等则继续判断到 j-i = 1
         *  2.2不相等则j--继续找与第一个相等的，到j-i = 1；i++
         *
         */
        if (s.length() < 2) {
            return s;
        }
        int begin = 0;
        int end = 0;
        int j = s.length()-1;
        int i = 0;
        String st = "";
        for (i = 0; i < s.length(); i++) {
            j = s.length()-1;
            for (j = j; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    boolean b = Palindrome(s,i,j);
                    if(b){
                        int max = Math.max(st.length(),s.substring(i,j+1).length());
                        if(st.length() >= s.substring(i,j+1).length()){
                            break;
                        }else{
                            st = s.substring(i,j+1);
                            begin = i;
                            end = j;
                            break;
                        }
                    }
//                    else {
//                        j--;
//                    }
                }
            }
        }
        for (int b = begin; b <= end; b++) {
//            st = st + s.charAt(b);
            System.out.println(b);
        }

        return st;
    }

    private static boolean Palindrome(String s,int begin,int end) {

        if (begin >= end) {
            return true;
        }

        if (s.charAt(begin) == s.charAt(end)) {
            // 递归调用，判断去掉首尾字符后的子串是否为回文串
            return Palindrome(s, begin + 1, end - 1);
        } else {
            return false;
        }
    }
}
