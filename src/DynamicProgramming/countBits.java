package DynamicProgramming;

/**
 * @author cbz
 * @version 1.0
 */

import java.util.Arrays;

/**
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 */
public class countBits {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        int n = 10;
        int count = 0;
        int[] ans = new int[n+1];
        for(int i = 0; i <= n; i++)
        {
            if (i % 2 == 0)
                ans[i] = ans[i / 2];
            else
                ans[i] = ans[i / 2] + 1;
        }
        System.out.println(Arrays.toString(ans));



    }


}
