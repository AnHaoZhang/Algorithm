package DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author cbz
 * @version 1.0
 */
public class sumSubarrayMins {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(sumSubarrayMins(arr));
    }
    public static int sumSubarrayMins(int[] arr) {
        /**
         * 暴力破解，动态规划

        int n = arr.length;
        int num = 1000000007;
        if(arr == null || n == 0){
            return 0;
        }
        int sum  = 0;
        //当前数
        for(int i = 0; i < n; i++){
            int min = arr[i];
            for(int j = i; j < n; j++){
                 min = Math.min(min, arr[j]);
                 sum = sum%num + min;

            }
        }
        return sum;
         */
        /**
         * 单调栈+贡献值
         */
        int n = arr.length;
        long num = (long)1000000007;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right,n);
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1);
        for(int i = 0;i < n;++i){
            while(st.size() > 1 && arr[st.peek()] >= arr[i]){
                right[st.pop()] = i;
            }
            left[i] = st.peek();
            st.push(i);


        }
        long min = 0;
        for(int i = 0; i < n;++i){
            min += (long)arr[i] * (i - left[i]) * (right[i] - i);
        }
        return (int)(min%num);

    }
}
