package DynamicProgramming;

import java.util.Scanner;

/**
 * @author cbz
 * @version 1.0
 * 【动态规划】背包问题
 */
public class knapsack {

    /**
     * 给定N个物品,每个物品有一个重量W和一个价值V。你有一个能装M重量的背包.问怎么装使得所装物品的总价值最大。每个物品只有一个
     */

    public static void knapsack(int n,int w,int[] values,int[] costs) {
        int[][] bag01 = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j >= costs[i])
                    bag01[i][j] = Math.max(bag01[i - 1][j - costs[i]] + values[i], bag01[i - 1][j]);
                else
                    bag01[i][j] = bag01[i - 1][j];
            }
        }
        System.out.println(bag01[n][w]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入物品个数n:");
        int n = sc.nextInt();
        
        int w = sc.nextInt();
        int[] values = new int[n + 1];
        int[] costs = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            values[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            costs[i] = sc.nextInt();
        }
        knapsack(n,w,values,costs);

    }

}
