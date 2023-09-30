package Dyncmic;

import java.util.Arrays;

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0) return 0;
        else if(nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int[] count = new int[10001];
        for(int i = 0; i < nums.length; i++)
            count[nums[i]]++;
        // dp[i] represents the largest point can be accessed
        int[] dpArray = new int[10001];
        dpArray[0] = 0 * count[0];
        dpArray[1] = 1 * count[1];
        for(int i = 2; i < 10001; i++)
            dpArray[i] = Math.max(dpArray[i - 1], dpArray[i - 2] + count[i] * i);
        return dpArray[10000];
    }
}