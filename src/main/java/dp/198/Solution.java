package dp;

import org.junit.jupiter.api.Test;

class Demo {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i < n + 1; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        for(int item : dp)
            System.out.println(item);
        return dp[n];
    }

    @Test
    public void test(){
        int[] nums = {1, 2, 3, 1};
        Demo solution = new Demo();
        int res = solution.rob(nums);
        System.out.println(res);
    }
}