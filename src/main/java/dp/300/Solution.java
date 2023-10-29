import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
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
        }
        for(int elem : dp)
            System.out.println(elem);
        return res;
    }

    public static void main(String[] args) {
        int[] test = {0, 1, 0, 3, 2, 3};
        Solution obj = new Solution();
        obj.lengthOfLIS(test);
    }
}