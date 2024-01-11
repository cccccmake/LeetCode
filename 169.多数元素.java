/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int target = nums.length / 2;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid] == target){
                left = mid + 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        return nums.length - left + 1;
    }
}
// @lc code=end

