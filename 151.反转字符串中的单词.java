/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start

class Solution {
    public String reverseWords(String s) {
        // trim() vs. strip()?
        // strip() is better :) it deals with Unicode
        // trim() deals only with characters <= U+0020 (space)
        s = s.trim();
        StringBuilder resBuilder = new StringBuilder();
        int left = s.length() - 1, right = s.length() - 1;
        while (left >= 0) {
            while (left >= 0 && s.charAt(left) != ' ')
                left--;
            // why the following logic leads to time limit exceeded
            // consider the string "abc "
            // left will stay on index 0, e.g., character 'a'
            /* 
                left++;
                resBuilder.append(s.substring(left, right + 1) + " ");
            */
            resBuilder.append(s.substring(left + 1, right + 1) + " ");
            // resBuilder.append(" ");
            while (left >= 0 && s.charAt(left) == ' ')
                left--;
            right = left;
        }
        // resBuilder.deleteCharAt(resBuilder.length() - 1);
        return resBuilder.toString().trim();
    }
}
// @lc code=end
