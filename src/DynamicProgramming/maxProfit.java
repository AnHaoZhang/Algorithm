package DynamicProgramming;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Arrays;

/**
 * @author cbz
 * @version 1.0
 */
/**
 *给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 */
public class maxProfit {
    public static int maxProfit(int[] prices) {
        /**
         * 1、只能选取后面数比前面数大的才有交易
         * 2、求得是数组差值
         */
        /**
         * 1.暴力破解法，问题无法得知
         * int[] num = new int[10];中数组的具体大小
         */
//        int n = prices.length;
//        int a = 0, b = 10;
//        int[] num = new int[b];
//        int[] temp  = new int[0];
//        for (int i = 0; i < n-1; i++) {
//            for (int j = i+1; j < n; j++) {
//                if (prices[i] < prices[j]) {
//                    if(a > b){
//                        b = num.length *2;
//                        temp = new int[b];
//                        for (int k = 0; k < num.length; k++) {
//                            temp[k] = num[k];
//                        }
//                        temp[a] = prices[j] - prices[i];
//                        a++;
//                    }else {
//                        num[a] = prices[j] - prices[i];
//                        a++;
//                    }
//                }
//            }
//
//        }
//        if (a > b){
//            System.out.println(Arrays.stream(temp).max().getAsInt());
//            return Arrays.stream(temp).max().getAsInt();
//        }else {
//            System.out.println(Arrays.stream(num).max().getAsInt());
//            return Arrays.stream(num).max().getAsInt();
//        }

        /**
         * 2、暴力破解修改
         */
//        int maxVlue = 0;
//
//        for (int i = 0; i < prices.length-1; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                int value = prices[j] - prices[i];
//                if (value > maxVlue) {
//                    maxVlue = value;
//
//                }
//            }
//        }
//        return maxVlue;
        /**
         * 3、动态规划
         */
        //定义minPrice并初始化为最大值
        int minPrice = Integer.MAX_VALUE;
        //定义maxProfit并初始化为0
        int maxProfit = 0;
        //遍历数组
        for (int i = 0; i < prices.length; i++) {
            //判断minPrice是否大于prices[i]，如果小于prices[i]，则prices[i]赋值给minPrice
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {//判断maxProfit是否大于prices[i] - minPrice，如果小于prices[i] - minPrice，则prices[i] - minPrice赋值给maxProfit
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }
}
