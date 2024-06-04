package PracticeOnceaday;

//import sun.security.krb5.KdcComm;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cbz
 * @version 1.0
 */
public class firstCompleteIndex2661 {

    public static void main(String[] args) {
        int[] arr = {1,4,5,2,6,3};
        int[][] mat = {{4,3,5},{1,2,6}};  //[[3,2,5],[1,4,6],[8,7,9]]
        System.out.println(firstCompleteIndex(arr, mat));
    }

    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int i ,j,k= 0;
        boolean[][] booleans = new boolean[m][n];
        int[] mArr = new int[m];
        int[] nArr = new int[n];

        // 循环数组arr
//        outerLoop:
        for ( i = 0; i < arr.length; i++) {
            // 循环mat
            outerLoop:
            for (j = 0; j < m; j++) {
                for ( k = 0; k < n; k++) {
                        if (arr[i] == mat[j][k]) {
                            booleans[j][k] = true;
                            if (mArr[j] == n-1 || nArr[k] == m-1) {
                                return i;
                            }else {
                                mArr[j] = mArr[j]+1;
                                nArr[k] = nArr[k]+1;
                            }
                        if (isRowAllTrue(booleans, j) ||isColumnAllTrue(booleans, k))
                            return i;
                        continue outerLoop;
                    }
                }
            }
        }
        return i;


//        HashMap<Integer, int[]> hashMap = new HashMap<Integer,int[]>();
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[0].length; j++) {
//                hashMap.put(mat[i][j], new int[]{i, j});
//            }
//        }
//        int[] row = new int[mat.length];
//        int[] col = new int[mat[0].length];
//        for ( int i = 0; i < arr.length; i++) {
//            int[] v =  hashMap.get(arr[i]);
//            ++row[v[0]];
//            if (row[v[0]] == mat.length) {
//                return i;
//            }
//            ++col[v[1]];
//            if (col[v[1]] == mat[0].length) {
//                return i;
//            }
//        }
//        return 0;

//        int n = mat.length;
//        int m = mat[0].length;
//        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < m; ++j) {
//                map.put(mat[i][j], new int[]{i, j});
//            }
//        }
//        int[] rowCnt = new int[n];
//        int[] colCnt = new int[m];
//        for (int i = 0; i < arr.length; ++i) {
//            int[] v = map.get(arr[i]);
//            ++rowCnt[v[0]];
//            if (rowCnt[v[0]] == m) {
//                return i;
//            }
//            ++colCnt[v[1]];
//            if (colCnt[v[1]] == n) {
//                return i;
//            }
//        }
//        return -1;
    }

    public static boolean isRowAllTrue(boolean[][] matrix, int rowIndex) {
        for (int col = 0; col < matrix[0].length; col++) {
            if (!matrix[rowIndex][col]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isColumnAllTrue(boolean[][] matrix, int colIndex) {
        for (int row = 0; row < matrix.length; row++) {
            if (!matrix[row][colIndex]) {
                return false;
            }
        }
        return true;
    }

}
