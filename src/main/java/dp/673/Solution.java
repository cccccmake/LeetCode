import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Map<Integer, Integer> rec = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
            rec.put(i, 0);
        // dp[i] refers to the largest non-decreasing length of the subarray nums[0, i]
        // select nums[0] as the last element of the sublist
        // [10,9,2,5,3,7,101,18]
        Arrays.fill(dp, 1);
        // dp[0] = 1;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    // why max => dp[i] = 0 when i > 0 during the initialization
                    dp[i] = Math.max(dp[i], dp[j] + 1); 
                }
            }
            res = Math.max(res, dp[i]);
            rec.put(res, rec.get(res) + 1);
        }
        return rec.get(res);
    }
}