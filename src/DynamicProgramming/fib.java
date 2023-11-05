package DynamicProgramming;

/**
 * @author cbz
 * @version 1.0
 */
public class fib {
    public static int fib(int n) {
        int a = 0;
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
    }
}
