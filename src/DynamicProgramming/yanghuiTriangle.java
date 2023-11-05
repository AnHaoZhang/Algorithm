package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author cbz
 * @version 1.0
 */
public class yanghuiTriangle {

    public static List<List<Integer>> generate(int n) {
        //定义一个嵌套的列表结构，外部列表包含多个内部列表
        List<List<Integer>> list = new ArrayList<>();
        //i代表层数即行
        for (int i = 0; i < n; i++) {
            //定义一个内部链表，用来存储每一行
            List<Integer> list1 = new ArrayList<>();
            //初始化每一行，j代表列数
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    //每一行的第一个和最后一个都为1
                    list1.add(1);
                } else {
                    //list.get(i - 1).get(j - 1) + list.get(i - 1).get(j)上一行的第j与第j-1个数之和为本行第j个数。
                    list1.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(list1);
        }
        return list;
    }
    public static void yanghuiTriangle(int n){
        //定义一个二维数组，用来存储每一行的值
        int[][] arr = new int[n][n];
        //初始化第一行为1
        for (int i = 0; i < n; i++) {
            //初始化第一列为1
            for (int j = 0; j <= i; j++) {
                /**
                 * arr[3][2] = arr[2][1] + arr[2][2]
                 * arr[1][1] = 1
                 */
                if (j == 0 || i == j) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
        }
        //打印二维数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入层数");
        int n = scanner.nextInt();
//        yanghuiTriangle(n);
        generate(n);
    }


}
