class Solution {
    public int tribonacci(int n) {
        if(n == 0 || n == 1 || n == 2) return n == 0 ? 0 : 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i < n+1; i++)
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        return dp[n];
    }
}