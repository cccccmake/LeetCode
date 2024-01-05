package com.cccccmake.leetcode.leetcode.editor.cn;

//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 1915 👎 0

/**
 * 分割等和子集
 *
 * @author cccccmake
 */
public class P416_PartitionEqualSubsetSum{
    public static void main(String[] args) {
        Solution solution = new P416_PartitionEqualSubsetSum().new Solution();
        System.out.println(solution.canPartition(new int[] {1,5,11,5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // sth similar: 1049
        // calculate the sum of the current array. if the result is odd, return false directly.
        // otherwise we get a backpack whose volume is sum/2. We need to put the goods (elements in nums[])
        // into this backpack. Afterward, we check whether the greatest value is sum/2 (volume).
    public boolean canPartition(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for(int elem : nums)
            sum += elem;
        if(sum % 2 == 1) return false;
        int volume = sum / 2;
        int[][] dpArray = new int[length][volume + 1];
        for(int i = 0; i <= volume; i++){
            if(i >= nums[0])
                dpArray[0][i] = nums[0];
        }
        for(int i = 1; i < length; i++){
            for(int j = 1; j <= volume; j++) {
                if (j < nums[i])
                    dpArray[i][j] = dpArray[i - 1][j];
                else
                    dpArray[i][j] = Math.max(dpArray[i - 1][j], dpArray[i - 1][j - nums[i]] + nums[i]);
            }
        }
        return dpArray[length - 1][volume] == volume;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}