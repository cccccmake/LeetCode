package com.cccccmake.leetcode.leetcode.editor.cn;

//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2625 👎 0

import java.util.Arrays;

/**
 * 零钱兑换
 *
 * @author cccccmake
 */
public class P322_CoinChange{
    public static void main(String[] args) {
        Solution solution = new P322_CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[] {1, 2, 5}, 11));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dpArray = new int[amount + 1];
        // Fill array with amount + 1 instead of Integer.MAX_VALUE
        Arrays.fill(dpArray, amount + 1);
        dpArray[0] = 0;
        for(int i = 0; i <= amount; i++){
            for(int coin : coins){
                if(i >= coin){
                    dpArray[i] = Math.min(dpArray[i - coin] + 1, dpArray[i]);
                }
            }
        }
        return dpArray[amount] == amount + 1 ? -1 : dpArray[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}