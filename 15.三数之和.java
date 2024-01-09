/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // index order => i -> left -> right
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break;
            // remove redundant starter, i.e., nums[i]
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            // assign left & right.
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    // remember this fuck.
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // remove redundant for element nums[left]
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    // remove redundat for element nums[right]
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left = left + 1;
                    right = right - 1;
                }else if(nums[i] + nums[left] + nums[right] > 0){
                    // ensure a diff. element for nums[right]
                    while(left < right && nums[right - 1] == nums[right]) right--;
                    right--;
                }else if(nums[i] + nums[left] + nums[right] < 0){
                    // ensure a diff. element for nums[left]
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    left++;
                }
            }
        }
        return res;
    }
}
// @lc code=end
