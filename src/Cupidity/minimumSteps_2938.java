package Cupidity;

import java.util.Scanner;

/**
 * @author cbz
 * @version 1.0
 */
public class minimumSteps_2938 {
    public static long minimumSteps(String s) {
        int cnt1 = 0;
        long ans = 0;
        for( char c:s.toCharArray()){
            if(c == '1'){
                cnt1++;
            }else{
                ans += cnt1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String s = scanner.nextLine(); // 读取整行文本

        System.out.println(minimumSteps(s));
        scanner.close();
    }
}
