package Arr;

import java.util.Arrays;
import java.util.List;

/**
 * @author cbz
 * @version 1.0
 */
public class isAcronym {

    public static void main(String[] args) {
        String s = "abc";
        String[] words = {"alice","bob","charlie"};
        isAcronym isAcronym = new isAcronym();
        System.out.println(isAcronym.isAcronym(Arrays.asList(words), s));
    }
    public boolean isAcronym(List<String> words, String s) {
        //1.获取字符串长度
        int len = s.length();
        String s1 = "";
        //2.遍历获取每个字符串第一个元素
        for (String word : words) {
            if (word.length() != ' ') {
                s1 += word.charAt(0);
                System.out.println(word.charAt(0));
            }
        }
        //3.判断字符串长s与s1
        if (s.length() == s1.length()) {
            //4.判断字符串是否相等
            if (s.equals(s1)) {
                return true;
            }
        }
        return false;
    }

}
