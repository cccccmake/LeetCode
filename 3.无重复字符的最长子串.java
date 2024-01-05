/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        // every single character is a string in length of 1
        int res = 1;
        Set<Character> rec = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            // clear the current set
            rec.clear();
            char currentChar = s.charAt(i);
            rec.add(currentChar);
            int j = i + 1;
            for (; j < s.length(); j++) {
                // redundant character found, break
                if (rec.contains(s.charAt(j))) {
                    break;
                } else {
                    // otherwise add the current character into the set
                    // & udpate the maximal length
                    rec.add(s.charAt(j));
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }
}
// @lc code=end
