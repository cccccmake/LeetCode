package com.cccccmake.leetcode.leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6926 👎 0

/**
 * 最长回文子串
 *
 * @author cccccmake
 */
public class P5_LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        int maxLen = 1;
        int begin = 0;
        boolean[][] dpArray = new boolean[length][length];
        for(int i = 0; i < length; i++)
            dpArray[i][i] = true;
        for(int subStringLen = 2; subStringLen <= length; subStringLen++){
            for(int i = 0; i < length; i++) {
                int j = i + subStringLen - 1;
                if (j >= length) break;
                else {
                    if (s.charAt(i) != s.charAt(j))
                        dpArray[i][j] = false;
                    else {
                        if (subStringLen == 2)
                            dpArray[i][j] = true;
                        else
                            dpArray[i][j] = dpArray[i + 1][j - 1];
                    }
                }
                if(dpArray[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}