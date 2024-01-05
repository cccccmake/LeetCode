package com.cccccmake.leetcode.leetcode.editor.cn;

//给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//输出：3
//解释：长度最长的公共子数组是 [3,2,1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 100 
// 
//
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 👍 1009 👎 0

/**
 * 最长重复子数组
 *
 * @author cccccmake
 */
public class P718_MaximumLengthOfRepeatedSubarray{
    public static void main(String[] args) {
        Solution solution = new P718_MaximumLengthOfRepeatedSubarray().new Solution();
        System.out.println(solution.findLength(new int[] {0, 0, 0, 0, 0}, new int[] {0, 0, 0, 0, 0}));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int res = 0;
        int[][] dpArray = new int[length1 + 1][length2 + 1];
        for(int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dpArray[i][j] = dpArray[i - 1][j - 1] + 1;
                    res = Math.max(res, dpArray[i][j]);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}