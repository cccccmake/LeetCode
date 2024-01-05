package com.cccccmake.leetcode.leetcode.editor.cn;

//给定一个整数数组
// prices，其中第 prices[i] 表示第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1676 👎 0

import java.net.DatagramPacket;

/**
 * 买卖股票的最佳时机含冷冻期
 *
 * @author cccccmake
 */
public class P309_BestTimeToBuyAndSellStockWithCooldown{
    public static void main(String[] args) {
        Solution solution = new P309_BestTimeToBuyAndSellStockWithCooldown().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dpArray = new int[length + 2][2];
        dpArray[1][1] = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            dpArray[i + 2][0] = Math.max(dpArray[i + 1][0], dpArray[i + 1][1] + prices[i]);
            dpArray[i + 2][1] = Math.max(dpArray[i + 1][1], dpArray[i][0] - prices[i]);
        }
        return dpArray[length + 1][0];
    }
//
//        public static int dfs(int i, boolean hold, int[] prices) {
//            if(i == 0)
//                return hold ? Integer.MIN_VALUE : 0;
//            if(hold)
//                return Math.max(dfs(i - 1, true), dfs(i - 2, false) - prices[i]);
//            return Math.max(dfs(i - 1, false), dfs(i - 1, true) + prices[i]);
//        }
}
//leetcode submit region end(Prohibit modification and deletion)

}