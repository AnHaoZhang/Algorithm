package PracticeOnceaday;

/**
 * @author cbz
 * @version 1.0
 */
public class secondGreaterElement {

    public static void main(String[] args) {
        int[] nums = {681862616,87599760,49595820,544311203};
        System.out.println(new secondGreaterElement().secondGreaterElement(nums));
    }

    public int[] secondGreaterElement(int[] nums) {
        int count = 0;
        int[] dp = new int[nums.length];

        for (int i = 0; i <= nums.length - 1; i++) {
            if (i >= nums.length - 2) {
                dp[i] = -1;
            } else {
                for (int j = i + 1; j < nums.length; j++) {

                    if (nums[i] < nums[j]) {
                        count++;
                        if (count == 2) {
                            dp[i] = nums[j];
                            count = 0;
                            break;
                        } else if (j == nums.length - 1) {
                            dp[i] = -1;
                            count = 0;
                        }
                    } else if (j == nums.length - 1)
                    {
                        dp[i] = -1;
                        count = 0;
                    }

                }
            }

        }
        return dp;
    }
}
