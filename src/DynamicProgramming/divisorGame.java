package DynamicProgramming;

import java.util.Scanner;

/**
 * @author cbz
 * @version 1.0
 */
public class divisorGame {
    public boolean divisorGame(int n) {
        int count = 0;
        for(int i = 1; i < n;){
            if(n % i == 0){
                n -= i;
                count++;
            }
        }
        return (count+1) % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组长度");
        int n = scanner.nextInt();
        scanner.close();
        divisorGame divisorGame = new divisorGame();
        System.out.println(divisorGame.divisorGame(n));
    }
}
