package Cupidity;

/**
 * @author cbz
 * @version 1.0
 */
public class canjump_55 {
    /**
     * 55. 跳跃游戏
     *
     * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
     *
     * 示例 1：
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     *
     * 示例 2：
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     * @param args
     */
    public static void main(String[] args) {
//        int[] arr = {2, 3, 1, 1, 4};
        int[] arr = {2,0,0};
        System.out.println(canJump(arr));
    }

    public static boolean canJump(int[] arr) {
        int n = arr.length; //初始化数组的长度。
        int a = n - 1; //初始化目标位置 a 为数组的最后一个位置。
        /**
         * 原因：最后一个位置（即 n-1 位置）是我们要跳跃到的目标位置。我们从倒数第二个位置（n-2 位置）开始向前遍历，目的是检查从每个位置 i 是否可以直接或通过中间位置跳跃到目标位置 a。
         * 思路：如果从位置 i 可以跳到位置 a（即 arr[i] >= a - i），我们将 a 更新为 i，表示我们可以将目标位置前移到 i。
         */
        for (int i = n - 2; i >= 0; i--) { // 从倒数第二个元素开始遍历
            /**
             * 条件解释：arr[i] 是从位置 i 可以跳跃的最大距离。a - i 是当前位置 i 到目标位置 a 的距离。如果 arr[i] 大于或等于 a - i，说明从位置 i 可以直接跳到目标位置 a。
             * 更新目标位置：如果条件满足，将目标位置 a 更新为当前位置 i，表示我们可以从位置 i 跳到最终目标位置。
             */
            if (arr[i] >= a - i) {
                a = i;
            }
        }
        return a == 0 ? true : false;
    }

}
