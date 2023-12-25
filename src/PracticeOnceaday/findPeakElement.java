package PracticeOnceaday;

/**
 * @author cbz
 * @version 1.0
 */
public class findPeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,5,6,4};
        System.out.println(new findPeakElement().findPeakElement(nums));
    }
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int i;
        boolean left = false, right = false;
        if (n <= 2) {
            return 0;
        }else {
            for ( i= 1; i < n - 1; i++) {
                //左边是否有小于该数的
                for (int j = 0; j < i; j++) {
                   if (nums[i] > nums[j]){
                       left = true;
                       break;
                   }
                }
                //右边是否有大于该数的
                for (int j = i + 1; j < n; j++) {
                    if (nums[i] > nums[j]){
                        right = true;
                        break;
                    }
                }
                if (left && right){
                    return i;
                }
            }
        }
        System.out.println(i);
        return i;
    }
}
