package DynamicProgramming;

/**
 * @author cbz
 * @version 1.0
 */
public class canjump {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(canJump(arr));
    }

    public static boolean canJump(int[] arr) {
        int n = arr.length;
        int a = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= a - i) {
                a = i;
            }
        }
        return a == 0 ? true : false;
    }
}
