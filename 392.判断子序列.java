/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPtr = 0, tPtr = 0, count = 0;
        if (s.length() > t.length())
            return false;
        while (sPtr < s.length() && tPtr < t.length()) {
            while (tPtr < t.length() && t.charAt(tPtr) != s.charAt(sPtr)) {
                tPtr++;
            }
            if (tPtr < t.length()) {
                sPtr++;
                tPtr++;
                count++;
            }
        }
        if(count == s.length()) return true;
        else return false;
    }
}
// @lc code=end
