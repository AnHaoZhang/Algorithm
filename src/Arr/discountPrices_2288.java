package Arr;

import java.sql.Array;

/**
 * @author cbz
 * @version 1.0
 */
public class discountPrices_2288 {
    public static String discountPrices(String sentence, int discount) {
//        String[] str1 = sentence.split(" ");
//        double d = 1 - discount / 100.0;
//        for (int j = 0; j<str1.length; j++) {
//            String s = str1[j];
//            if (s.length() > 1 && s.charAt(0) == '$') {
//                char[] charArray = s.toCharArray();
//                for (int i = 1; i < charArray.length; i++) {
//                    if (Character.isDigit(charArray[i])) {
//                        str1[j] = String.format("$%.2f", Long.parseLong(str1[j].substring(1)) * d);
//                    }
//                }
//            }
//        }
//        return String.join(" ", str1);
        String[] str1 = sentence.split(" ");
        double d = 1 - discount / 100.0;
        for (int j = 0; j < str1.length; j++) {
            String s = str1[j];
            if (s.startsWith("$") && s.length() > 1) {
                boolean a = true;
                char[] charArray = s.toCharArray();
                for (int i = 1; i < charArray.length; i++) {
                    if (!Character.isDigit(charArray[i])) {
                        a = false;
                    }
                }
                if (a) {
                    str1[j] = String.format("$%.2f", Long.parseLong(str1[j].substring(1)) * d);
                }
            }
        }
        return String.join(" ", str1);
    }


    public static void main(String[] args) {
        String sentence = "there are $1 $2 and 5$ candies in the shop";
        int discount = 50;
        System.out.println(discountPrices(sentence, discount));
    }
}
