/*
 * @lc app=leetcode.cn id=1658 lang=java
 *
 * [1658] 将 x 减到 0 的最小操作数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if(sum < x) return -1;
        int right = 0;
        int lsum = 0, rsum = sum;
        int ans = n + 1;
        for(int left = -1; left < n; left++){
            if(left != -1){
                lsum += nums[left];
            }
            while(right < n && lsum + rsum > x){
                rsum -= nums[right++];
            }
            if(lsum + rsum == x){
                ans = Math.min(ans, (left + 1) + (n - right));
            }
            // hidden condition here:
            // else if (lsum + rsum < x) continue;
            // i.e., left++;
        }
        return ans > n ? -1 : ans;
    }
}
// @lc code=end

