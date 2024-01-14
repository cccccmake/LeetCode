/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int left = 0, right = 0, sum = 0, res = length + 1;
        for(; right < length; right++){
            sum += nums[right];
            while(sum >= target){
                res = Math.min(right - left + 1, res);
                sum -= nums[left++];
            }
            /*
            while(sum - nums[left] >= target)
                sum -= nums[left++];
            if(sum >= target)
                res = min(res, right - left + 1);
             */
        }
        return res > length ? 0 : res;
    }
}
// @lc code=end

