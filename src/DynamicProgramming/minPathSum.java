package DynamicProgramming;

/**
 * @author cbz
 * @version 1.0
 */
public class minPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,2},{1,1}};
//        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
//        int[][] grid = {{1,2},{5,6},{1,1}};
        System.out.println(new minPathSum().minPathSum(grid));
    }
    public int minPathSum(int[][] grid) {
//        int m = grid.length; //行
//        int n = grid[0].length; //列
//        int count = 0;
//        for (int i = m-1;i>=0 ;i--){
//            if (i > 0)
//                grid[i - 1][n - 1] = grid[i][n - 1] + grid[i - 1][n - 1];
//            for (int j = n-1; j >= 0;j--){
//                if (j >0 && count< n-1){
//                    grid[m-1][j-1] = grid[m-1][j] + grid[m-1][j-1];
//                    count++;
//                }
//                if (i<m-1 && j<n-1) {
//                    grid[i][j] = Math.min(grid[i][j]+grid[i][j+1],grid[i][j]+grid[i+1][j]);
//                }
//
//                System.out.println("g:"+i+"行"+j+"列:"+grid[i][j]);
//            }
//        }
//        return grid[0][0];

        int m = grid.length; // 行数
        int n = grid[0].length; // 列数
        // 从右下角开始向左上角遍历
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 当前位置不是左上角元素
                if (i < m - 1 || j < n - 1) {
                    // 更新当前位置的最小路径和
                    grid[i][j] += Math.min(
                            // 从右方到达当前位置
                            (j < n - 1) ? grid[i][j + 1] : Integer.MAX_VALUE,
                            // 从下方到达当前位置
                            (i < m - 1) ? grid[i + 1][j] : Integer.MAX_VALUE
                    );
                }
            }
        }
        return grid[0][0]; // 返回左上角元素的最小路径和
    }
}
