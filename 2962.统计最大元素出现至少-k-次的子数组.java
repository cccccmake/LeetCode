/*
 * @lc app=leetcode.cn id=2962 lang=java
 *
 * [2962] 统计最大元素出现至少 K 次的子数组
 */

// @lc code=start

class Solution {
    public long countSubarrays(int[] nums, int k) {
        // find the max value
        int maxVal = -1;
        for(int num : nums){
            maxVal = Math.max(num, maxVal);
        }
        int count = 0, left = 0;
        long res = 0;
        for(int num : nums){
            if(num == maxVal){
                count++;
            }
            while(count == k){
                if(nums[left++] == maxVal)
                    count--;
            }
            // subarrays in which count(3) >= 3 for array [0, 1, 2, 3, 3, 3]
            // [0, 1, 2, 3, 3, 3], [1, 2, 3, 3, 3], [2, 3, 3, 3], [3, 3, 3]
            // 共4个
            res += left;
        }
        return res;
        // while(right < nums.length){
        //     if(nums[right++] == maxVal)
        //         count++;
        //     if(count >= k){
        //         res++;
        //         while(nums[left] != maxVal){
        //             left++;
        //             res++;
        //             count--;
        //         }
        //     }
        // }
        // if(right == nums.length && count < k) return 0;
        // // now right = nums.length
        // right--;
        // while(left <= nums.length - k){
        //     if(nums[left++] == maxVal){
        //         count--;
        //         if(count >= k)
        //             res++;
        //     }
        // }
    }
}
// @lc code=end

