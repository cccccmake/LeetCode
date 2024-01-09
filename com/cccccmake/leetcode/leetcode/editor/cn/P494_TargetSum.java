package com.cccccmake.leetcode.leetcode.editor.cn;

//给你一个非负整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 回溯 👍 1782 👎 0

/**
 * 目标和
 *
 * @author cccccmake
 */
public class P494_TargetSum{
    public static void main(String[] args) {
        Solution solution = new P494_TargetSum().new Solution();
        System.out.println(solution.findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int length = nums.length;
        int sum = 0;
        for(int elem : nums)
            sum += elem;
        if((sum + target) % 2 == 1 || sum < target) return 0;
        int volume = (sum + target) / 2;
        // test case: {100} -200
        if(volume < 0) return 0;
        /*
        int[][] dpArray = new int[length + 1][volume + 1];
        // init only this single element!
        dpArray[0][0] = 1;
        for(int i = 1; i <= length; i++){
            for(int j = 0; j <= volume; j++){
                if(nums[i - 1] <= j)
                    dpArray[i][j] = dpArray[i - 1][j] + dpArray[i - 1][j - nums[i - 1]];
                else
                    dpArray[i][j] = dpArray[i - 1][j];
            }
        }
        return dpArray[length][volume];
        */
        // 1-dimensional dpArray
        int[] dpArray = new int[volume + 1];
        dpArray[0] = 1;
        for(int elem : nums){
            for(int j = volume; j >= 0; j--){
                if(j >= elem)
                    dpArray[j] += dpArray[j - elem];
            }
            System.out.println("===");
            for(int item : dpArray)
                System.out.print(item + ", ");
            System.out.println("===");
        }
        return dpArray[volume];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}