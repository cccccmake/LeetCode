package com.cccccmake.leetcode.leetcode.editor.cn;

//给定一个未排序的整数数组
// nums ， 返回最长递增子序列的个数 。 
//
// 注意 这个数列必须是 严格 递增的。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 
//
// 提示: 
//
// 
// 
//
// 
// 1 <= nums.length <= 2000 
// -10⁶ <= nums[i] <= 10⁶ 
// 
//
// Related Topics 树状数组 线段树 数组 动态规划 👍 823 👎 0

import java.net.DatagramPacket;
import java.util.Arrays;

/**
 * 最长递增子序列的个数
 *
 * @author cccccmake
 */
public class P673_NumberOfLongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new P673_NumberOfLongestIncreasingSubsequence().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        int[] dpArray = new int[length];
        int[] count = new int[length];
        int maxCount = 1;
        int res = 0;
        Arrays.fill(dpArray, 1);
        Arrays.fill(count, 1);
        for(int i = 1; i < length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]) {
                    if (dpArray[i] < dpArray[j] + 1) {
                        count[i] = count[j];
                    }
                    if (dpArray[i] == dpArray[j] + 1) {
                        count[i] += count[j];
                    }
                    dpArray[i] = Math.max(dpArray[i], dpArray[j] + 1);
                }
                maxCount = Math.max(maxCount, dpArray[i]);
            }
        }
        for(int i = 0; i < length; i++){
            if(maxCount == dpArray[i])
                res += count[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}