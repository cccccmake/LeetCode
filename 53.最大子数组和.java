/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start

import java.util.Arrays;

class Solution {

    public int maxSubArray(int[] nums) {
        // int length = nums.length;
        // // dpArray[i][j] => the maximum sum of subarray nums[i, j]
        // int[][] dpArray = new int[length][length];
        // // init the dpArray
        // for (int[] array : dpArray) {
        //     Arrays.fill(array, -1);
        // }
        // for (int i = 0; i < length; i++) {
        //     dpArray[i][i] = nums[i];
        // }
        // for (int i = length - 1; i >= 0; i--) {
        //     for(int j = length - 1; j >= i; j--){
        //         if(j != 0)
        //             dpArray[i][j] = Math.max(dpArray[i][j - 1] + nums[j], dpArray[i][j]);
        //     }
        // }
        // return dpArray[0][length - 1];
        int[] dpArray = new int[nums.length];
        dpArray[0] = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            // why nums[i] as a single candidate?
            // consider dpArray[i - 1] is negative
            // then nums[i] is a better choice
            dpArray[i] = Math.max(dpArray[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dpArray[i]);
        }
        return res;
    }
}
// @lc code=end

