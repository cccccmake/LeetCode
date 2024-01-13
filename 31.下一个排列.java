/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        // what happens if index == 0?
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]){
                index = i;
                break;
            }
        }
        if(index == -1){
            Arrays.sort(nums);
            return;
        }
        int j = nums.length - 1;
        while(j >= 0 && nums[index] >= nums[j]) j--;
        int temp = nums[index];
        nums[index] = nums[j];
        nums[j] = temp;
        return;
    }
}
// @lc code=end

