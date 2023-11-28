package DynamicProgramming;

/**
 * @author cbz
 * @version 1.0
 */
public class fib {
//    public static int fib(int n) {
//        int a = 0;
//        if (n == 0 || n == 1) {
//            return n;
//        }
//        return fib(n - 1) + fib(n - 2);
//    }
public static int trainWays(int num) {
    final int n = 1000000007;
    int i = 0;
//    if(num <= 3){
//        return num;
//    }
//    int[] dp = new int[num+1];
//    dp[0] = 0;
//    dp[1] = 1;
//    dp[2] = 2;
//    dp[3] = 3;
//    for(i = 4;i <= num;i++){
//        dp[i] = dp[i-1]+dp[i-2];
//    }
//    return dp[i-1];
    if(num == 0){
        return 1;
    }else if(num <= 3){
        return num;
    }else{
        int[] dp = new int[num+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(i = 4;i <= num;i++){
            dp[i] = (dp[i-1]+dp[i-2])%n;
        }
        return dp[num];

    }
}

    public static void main(String[] args) {
//        System.out.println(fib(10));
        System.out.println(trainWays(46));
    }
}
