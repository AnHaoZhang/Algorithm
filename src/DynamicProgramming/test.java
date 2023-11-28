package DynamicProgramming;

/**
 * @author cbz
 * @version 1.0
 */
public class test {
    public static void main(String[] args) {
        int num = -1;  //    768374 2147483646
        System.out.println(reverseBits(num));
        System.out.println(convertToBinary(num));
    }

    public static int reverseBits(int num) {
        char[] binaryArray = new char[32];

        if (num == 0) {
            return 1; // 32位的0表示
        } else if (num < 0) {
//            char[] binaryArray = new char[32];  // 32位二进制数的数组

            // 处理符号位
            binaryArray[0] = (num < 0) ? '1' : '0';

            // 将负数转为正数处理
            if (num < 0) {
                num = -num;
            }

            // 补足31位
            for (int i = 31; i > 0; i--) {
                int remainder = num % 2;
                binaryArray[i] = (char) (remainder + '0');  // 存储余数，注意将数字转为字符
                num /= 2;
            }

            // 取反
            for (int i = 1; i < 32; i++) {
                binaryArray[i] = (binaryArray[i] == '0') ? '1' : '0';
            }

            // 加1
            int carry = 1;
            for (int i = 31; i >= 0; i--) {
                char currentBit = binaryArray[i];
                int sum = (currentBit - '0') + carry;
                binaryArray[i] = (char) (sum % 2 + '0');
                carry = sum / 2;
            }
        } else {
            // 处理非负数的情况
            for (int i = 0; i < 32; i++) {
                int remainder = num % 2;
                binaryArray[i] = (char) (remainder + '0');  // 在最前面插入余数
                num /= 2;
            }
        }

        int flipCount = 1; // 可以翻转的0的个数
        int maxConsecutiveOnes = 0;
        int currentConsecutiveOnes = 0;
        int a = 0;
        for (int i = 0; i < binaryArray.length; i++) {
            if (binaryArray[i] == '1') {
                // 当前位是1，增加当前连续1的长度
                currentConsecutiveOnes++;
            } else {
                // 当前位是0，尝试翻转0
                if (flipCount > 0) {
                    flipCount--;
                    currentConsecutiveOnes++;
                    a = i;
                } else {
                    // 不能翻转更多的0，重置翻转计数器和当前连续1的长度
                    flipCount = 1;
                    currentConsecutiveOnes = 0;
                    i = a;
                }
            }
            // 全是1的情况
            if (binaryArray.length == currentConsecutiveOnes && flipCount == 1) {
                currentConsecutiveOnes++;
            }

            // 更新最大连续1的长度
            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, currentConsecutiveOnes);
        }


        return maxConsecutiveOnes;
    }

    public static String convertToBinary(int num) {
        char[] binaryArray = new char[32];  // 32位二进制数的数组

        // 处理符号位
        binaryArray[0] = (num < 0) ? '1' : '0';

        // 将负数转为正数处理
        if (num < 0) {
            num = -num;
        }

        // 补足31位
        for (int i = 31; i > 0; i--) {
            int remainder = num % 2;
            binaryArray[i] = (char) (remainder + '0');  // 存储余数，注意将数字转为字符
            num /= 2;
        }

        // 取反
        for (int i = 1; i < 32; i++) {
            binaryArray[i] = (binaryArray[i] == '0') ? '1' : '0';
        }

        // 加1
        int carry = 1;
        for (int i = 31; i >= 0; i--) {
            char currentBit = binaryArray[i];
            int sum = (currentBit - '0') + carry;
            binaryArray[i] = (char) (sum % 2 + '0');
            carry = sum / 2;
        }

        return new String(binaryArray);
    }
}
