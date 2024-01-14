/*
 * @lc app=leetcode.cn id=713 lang=java
 *
 * [713] 乘积小于 K 的子数组
 */

// @lc code=start
class Solution {
    public int numSubarrayProductLessThanKOrigin(int[] nums, int k) {
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
            /*
             * A wrong version for testcase [1, 2, 3], k = 0
            while (multiply >= k)
                multiply /= nums[left++];
            if (left <= right)
                res += right - left + 1;
            // multiply >= 0 is always true
            // index 3 will be accessed
             */
        }
        return res;
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // as the elements within nums are positive <=> no result for k <= 1
        if(k <= 1) return 0;
        int res = 0;
        int left = 0;
        int prod = 1;
        // enumerate the end of the subarray
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            // once the subarray is larger than the target k => shrink
            // i.e., shrink the left boundary
            while (prod >= k) {
                prod /= nums[left++];
            }
            // assuming we have the following subarrays:
            // [l, r], [l + 1, r], [l+2, r], ..., [r, r]
            res += right - left + 1;
        }
        return res;
    }
}
// @lc code=end
