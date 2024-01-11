/*
 * @lc app=leetcode.cn id=1480 lang=java
 *
 * [1480] 一维数组的动态和
 */

// @lc code=start
class Solution {
    public int[] runningSum(int[] nums) {
        int[] dpArray = new int[nums.length];
        dpArray[0] = nums[0];
        // dpArray[1] = nums[1];
        for(int i = 1; i < nums.length; i++){
            dpArray[i] = nums[i] + dpArray[i - 1];
        }
        return dpArray;
    }
}
// @lc code=end

