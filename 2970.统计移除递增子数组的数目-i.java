/*
 * @lc app=leetcode.cn id=2970 lang=java
 *
 * [2970] 统计移除递增子数组的数目 I
 */

// @lc code=start
class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        // find the last element in the non-decreasing prefix subarray
        int lastIdx = -1;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] >= nums[i + 1]){
                lastIdx = i;
                break;
            }
        }
        // if lastIdx has not been changed <=> the array is already non-decreasing
        if(lastIdx == -1)
            return nums.length * (nums.length + 1) / 2;
        res = lastIdx + 2;
        for(int rightIdx = nums.length - 1; rightIdx == nums.length - 1 || nums[rightIdx] < nums[rightIdx + 1]; rightIdx--){
            while(rightIdx > 0 && nums[lastIdx] >= nums[rightIdx]){
                lastIdx--;
            }
            res += lastIdx + 2;
        }
        return res;
    }
}
// @lc code=end

