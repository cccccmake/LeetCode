package com.cccccmake.leetcode.leetcode.editor.cn;

//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。 
//
// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bbbab"
//输出：4
//解释：一个可能的最长回文子序列为 "bbbb" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出：2
//解释：一个可能的最长回文子序列为 "bb" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 1125 👎 0

/**
 * 最长回文子序列
 *
 * @author cccccmake
 */
public class P516_LongestPalindromicSubsequence{
    public static void main(String[] args) {
        Solution solution = new P516_LongestPalindromicSubsequence().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dpArray = new int[length + 1][length + 1];
        // init the cross corner elements
        // each character is a palindrome
        for(int i = 0; i < length; i++)
            dpArray[i][i] = 1;
        for(int i = 1; i <= length; i++){
            for(int j = i; j <= length; j++){
                if(s.charAt(i - 1) == s.charAt(j - 1))
                    dpArray[i][j] = dpArray[i + 1][j - 1] + 2;
                else
                    dpArray[i][j] = Math.max(dpArray[i + 1][j], dpArray[i][j - 1]);
            }
        }
        return dpArray[length][length];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}