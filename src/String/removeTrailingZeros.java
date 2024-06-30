package String;

/**
 * @author cbz
 * @version 1.0
 */
public class removeTrailingZeros {
    public static String removeTrailingZeros(String num) {
        /**
         * 注意事项
         * 循环结束条件
         * num.charAt(length -1) == '0' 是单引号表示字符
         * num.substring(0, len)，字符串截取方法是前闭后开范围是[0,len)
         */
        //方案一
//        int length = num.length();
//        for (int i = 0; i < num.length(); i++) {
//            if(num.charAt(length -1) == '0'){
//                length--;
//            }
//        }
//        System.out.println(num.substring(0,length));
//        return num.substring(0,length);

        //方案二
         int len = num.length();
         while (len > 0 && num.charAt(len - 1) == '0') {
             len--;
         }
         return num.substring(0, len);
    }

    public static void main(String[] args) {
        String num = "111000";
        System.out.println(removeTrailingZeros(num));
    }
}
