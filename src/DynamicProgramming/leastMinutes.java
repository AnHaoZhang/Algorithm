package DynamicProgramming;

/**
 * @author cbz
 * @version 1.0
 */
public class leastMinutes {
    public static int leastMinutes(int n) {
//        if(n < 3){
//            return n;
//        }
        int result = 0;
        int m = n;
        while (m > 0) {
            result++;
            m >>= 1;
        }
        // if(n-2^(result-1)>0){
        //     return result+1;
        // }else{
        //     return result;
        // }
//        int count = 1<<2;
//
//        int s = n-(1<<(result-1));

        return (n-(1<<(result-1))>0)? result+1 : result;
    }

    public static void main(String[] args) {
        System.out.println(leastMinutes(7));
    }
}
