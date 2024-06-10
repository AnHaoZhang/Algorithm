package Cupidity;

import java.util.Arrays;

/**
 * @author cbz
 * @version 1.0
 */
public class numRescueBoats_881 {
    public static int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int light = 0, heavy = people.length - 1;
        while (light <= heavy) {
            if (people[light] + people[heavy] <= limit) {
                ++light;
            }
            --heavy;
            ++ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a={3,2,2,1};
        int b = 3;
        System.out.println(numRescueBoats(a,b));
    }
}
