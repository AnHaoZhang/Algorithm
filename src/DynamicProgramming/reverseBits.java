package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cbz
 * @version 1.0
 */
public class reverseBits {
    /**
     * 将十进制数转换为二进制
     *
     * @param decimal 十进制数
     * @return 二进制表示
     */
    public static int decimalToBinary(int decimal) {

        StringBuilder binary = new StringBuilder();

        // 当十进制数不为0时，进行转换
        while (decimal > 0) {
            int remainder = decimal % 2;  // 取余数
            binary.insert(0, remainder);  // 将余数插入到字符串的最前面
            decimal /= 2;                 // 除以2，更新十进制数
        }

        int count = 0 ;//最大连续1计数
        int i = 0;
        int n = 0; //满足 c[i] == 0 && c[i - 1] != 0 计数
        int tag = 0;
        int[] c = new int[binary.length()+1];
        int lastIndex = -1;
        int lastNOzero = 0;
        int zeroCount = 0;


        // 如果原始十进制数为0，直接返回 "0"
        if (binary.length() == 0) {
            return 1;
        }
        //找到连续最大值与连续值数组c[i]
        for ( i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1'){
                c[i] = ++count;
                if (c[i] == binary.length()) {
                    return c[i]+1;
                }
                zeroCount = 0;
            }
            else if (binary.charAt(i) == '0') {
                c[i] = --zeroCount;
                count = 0;
            }
            System.out.println("c[i] = " + c[i]);
        }

        int d = 0;

        if (c.length < 2) {
            return 1; // 表示无法找到第二大的元素
        }
        for (i = 0; i < c.length; i++) {
            if (c[i] == -1) {
                d++;
                System.out.println("c[i] =111 " + c[i-1]+"@@"+i);
            }
            if (c[i] == -1 && c[i+1] >=0) {
                n++;
            }
            if (c[i] <=-2 && c[i+1] >=0) {
                d++;
                System.out.println("c[i] =111 " + c[i-1]+"@@"+i);
            }
        }
        int max ;
        int[] indices = new int[n+1];
        System.out.println(n+"$$$"+d);
//        最后一个非零数的下标与值
        for (i = c.length - 1 ;i>=0;i--) {
            if (c[i] != 0) {
                lastIndex = i;
                lastNOzero = c[i];
                indices[n] = lastIndex;
                break;
            }
        }
        if (n == 1) {
            max = lastNOzero + 1;
            return max;
        }

//
//        for (i = 1; i < c.length-1; i++) {
//            if (c[i] == 0 && c[i - 1] != 0 ) {
//                System.out.println("c[i] =111 " + c[i-1]+"@@"+i);
//            }
//        }
//
//        boolean inConsecutiveZeros = false;
//        // 计算满足条件的元素个数
//        for ( i = 0; i < c.length ; i++) {
////            if (c[i] == 0 && c[i - 1] != 0 ) {
////                n++;
////
////            }
//            if (c[i] == 0) {
//                if (!inConsecutiveZeros) {
//                    tag++;
//                    inConsecutiveZeros = true;
//                }
//            } else {
//                inConsecutiveZeros = false;
//            }
//
//        }
//        System.out.println(tag+"$$$");
//
//        int[] indices = new int[n+1];
//        int index = 0;
//        // 找到满足条件的元素的下标
//        for ( i = 1; i < c.length - 1; i++) {
//            if (c[i] == 0 && c[i - 1] != 0 ) {
//                indices[index]= i-1;
//                index++;
//            }
//        }
//
//        int max ;
//        int max1 = c[indices[0]];
//        int max2 = c[indices[0]];
//        if (n == 1) {
//            max = lastNOzero + 1;
//            return max;
//        }
//        int q= 0 ,p = 0;
//        for (i = 0; i < indices.length-1; i++) {
//            if (i<1 && indices[i+1]-c[indices[i+1]] == indices[i]+1) {
//                q = c[indices[i]] + c[indices[i+1]];
//                max1 = Math.max(max1,q);
//            }
//
//            if(i > 0 && indices[i]-c[indices[i]] == indices[i-1]+1) {
//                q = c[indices[i]] + c[indices[i+1]];
//                max1 = Math.max(max1,q);
//            }
//            else {
//                p = c[indices[i]] + c[indices[i+1]];
//                max2 = Math.max(max2,p);
//            }
//            System.out.println("indices[i] = " + indices[i]+" c[indices[i]] = " + c[indices[i]]);
//        }

        return 0;
    }

    public static void main(String[] args) {
//        int num = 1783;  //    768374 2147483646
         int num =45725232 ;
        System.out.println(reverseBits.decimalToBinary(num));
    }
}
