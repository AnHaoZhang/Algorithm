package Arr;
import java.util.Scanner;
/**
 * @author cbz
 * @version 1.0
 * A+B问题|
 */
public class ABMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");
            int a = Integer.parseInt(numbers[0]);
            int b = Integer.parseInt(numbers[1]);

            int sum = a + b;
            System.out.println(sum);
        }
        scanner.close();
    }
}
