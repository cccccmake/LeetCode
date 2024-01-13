/*
 * @lc app=leetcode.cn id=1155 lang=java
 *
 * [1155] 掷骰子等于目标和的方法数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_007;
    public int numRollsToTarget(int n, int k, int target) {
        if(target < n || n * k < target) return 0;
        int[][] memo = new int[n + 1][target + 1];
        for(int[] row : memo)
            Arrays.fill(row, -1);
        return dfs(n, target, k, memo);
    }
    private int dfs(int i, int j, int k, int[][] memo){
        if(j < 0) return 0;
        if(i == 0) return j == 0 ? 1 : 0;
        int res = 0;
        if(memo[i][j] != -1) return memo[i][j];
        for(int x = 1; x <= k; x++){
            res = (res + dfs(i - 1, j - x, k, memo)) % MOD;
        }
        return memo[i][j] = res;
    }
    /*
     * if(target < 0) return 0;
        if(target == 0 && n == 0) return 1;
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= k; j++){
                res += numRollsToTarget(n - 1, k, target - k) % MOD;
            }
        }
        return res;
     */
}
// @lc code=end

