package DynamicProgramming;

import java.util.Scanner;

/**
 * @author cbz
 * @version 1.0
 */
public class maxSales {
    public static int maxSales(int[] sales){
        int pre = 0, maxAns = sales[0];
        for (int x : sales) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sales = new int[n];
        for (int i = 0; i < n; i++) {
            sales[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(maxSales.maxSales(sales));
    }
}
