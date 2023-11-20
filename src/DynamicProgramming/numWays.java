package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author cbz
 * @version 1.0
 */

/**
 * 图的相关知识
 * 邻接表
 */
public class numWays {

    List<List<Integer>> edges = new ArrayList<List<Integer>>(); // 存储图的邻接表 初始化邻接表

    int count ,n,k;   // 用于存储结果的变量，以及总玩家数n和传递轮数k


    public int numWays(int n, int[][] relation, int k) {
        count  = 0;                   // 初始化结果变量
        this.n = n;                  // 初始化总玩家数
        this.k = k;                  // 初始化传递轮数
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());  // 为每个玩家创建一个邻接列表
        }
        for (int[] edge : relation) {
            edges.get(edge[0]).add(edge[1]);   // 将传递关系添加到邻接表中
        }
        dfs(0, 0);                   // 调用深度优先搜索函数从小A开始进行遍历
        return count ;                 // 返回结果
    }

    public void dfs(int i, int s) {
        if (s == k) {            // 如果已经传递了k轮
            if (i == n - 1) {     // 如果当前到达目标小伙伴
                count ++;               // 增加方案数
            }
            return;                   // 返回上一层递归
        }
        List<Integer> list = edges.get(i);  // 获取当前节点的邻接列表
        for (int next : list) {
            dfs(next, s + 1);  // 递归调用下一层深度优先搜索
        }
    }
//    List<List<Integer>> edges = new ArrayList<List<Integer>>();
//
//    int count = 1 ,n,k;
//    public int numWays(int n,int[][] relation,int k) {
//        count = 0;
//        this.k = k;
//        this.n = n;
//        //创建list大小
//        for (int j = 0; j < n; j++) {
//            edges.add(new ArrayList<>());
//        }
//        for (int[] edge : relation) {
//            //
//            edges.get(edge[0]).add(edge[1]);
//        }
//        dfs(0,0);
//        return count;
//    }
//
//    public void dfs(int i,int s){
//        if (s == k){
//            if (i == n-1){
//                count++;
//            }
//            return;
//        }
//        List<Integer> list = edges.get(i);
//        for (int next : list) {
//            dfs(next,s+1);
//        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]]
        int[][] relation = {{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};

        int k = scanner.nextInt();
        scanner.close();
        numWays numWays = new numWays();
        System.out.println(numWays.numWays(n, relation, k));
    }

}
