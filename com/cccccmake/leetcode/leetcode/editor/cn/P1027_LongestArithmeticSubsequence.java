package com.cccccmake.leetcode.leetcode.editor.cn;

//给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。 
//
// 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，且 0 <= i1 < i2 < ... <
// ik <= nums.length - 1。并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么
//序列 seq 是等差的。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,6,9,12]
//输出：4
//解释： 
//整个数组是公差为 3 的等差数列。
// 
//
// 示例 2： 
//
// 
//输入：nums = [9,4,7,2,10]
//输出：3
//解释：
//最长的等差子序列是 [4,7,10]。
// 
//
// 示例 3： 
//
// 
//输入：nums = [20,1,15,3,10,5,8]
//输出：4
//解释：
//最长的等差子序列是 [20,15,10,5]。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 1000 
// 0 <= nums[i] <= 500 
// 
//
// Related Topics 数组 哈希表 二分查找 动态规划 👍 347 👎 0

import java.util.*;

/**
 * 最长等差数列
 *
 * @author cccccmake
 */
public class P1027_LongestArithmeticSubsequence{
    public static void main(String[] args) {
        Solution solution = new P1027_LongestArithmeticSubsequence().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestArithSeqLength(int[] nums) {
        // dpArray[i]: the longest length of the subarray of array nums, i.e., nums[0, i]
        Map<Integer, Integer>[] dpArray = new HashMap[nums.length];
        // what's this fuck?
        Arrays.setAll(dpArray, e -> new HashMap<>());
        int res = 0;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                // difference of nums[i] and nums[j]
                int diff = nums[i] - nums[j];
                // nums[i] as the last element of the target array
                dpArray[i].put(diff, dpArray[j].getOrDefault(diff, 1) + 1);
                res = Math.max(res, dpArray[i].get(diff));
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}