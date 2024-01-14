/*
 * @lc app=leetcode.cn id=713 lang=java
 *
 * [713] 乘积小于 K 的子数组
 */

// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int left = 0;
        int multiply = 1;
        for (int right = 0; right < nums.length; right++) {
            multiply *= nums[right];
            while (multiply >= k && left <= right) {
                multiply /= nums[left++];
            }
            if (left <= right)
                res += right - left + 1;
        }
        return res;
    }
}
// @lc code=end
