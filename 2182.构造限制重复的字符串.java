/*
 * @lc app=leetcode.cn id=2182 lang=java
 *
 * [2182] 构造限制重复的字符串
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String repeatLimitedStringSUCKS(String s, int repeatLimit) {
        char[] charSet = s.toCharArray();
        int[] charCount = new int[26];
        for (char c : charSet) {
            charCount[c - 'a']++;
        }
        Queue<Character> backUpChar = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            if (charCount[i] >= repeatLimit) {
                for (int j = 0; j < repeatLimit; j++) {
                    res.append((char) (i + 'a'));
                }
                charCount[i] -= repeatLimit;
                backUpChar.offer((char) (i + 'a'));
            } else {
                for (int j = 0; j < charCount[i]; j++) {
                    res.append((char) (i + 'a'));
                }
            }

            if (!backUpChar.isEmpty() && (char) (i + 'a') != backUpChar.peek()) {
                int maxRepeat = charCount[backUpChar.peek() - 'a'];
                if (maxRepeat <= repeatLimit) {
                    for (int j = 0; j < maxRepeat; j++) {
                        res.append(backUpChar.peek());
                    }
                    backUpChar.poll();
                } else {
                    for (int j = 0; j < repeatLimit; j++) {
                        res.append(backUpChar.peek());
                    }
                    charCount[backUpChar.peek() - 'a'] -= repeatLimit;
                }
            }
        }
        return res.toString();
    }

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] charCount = new int[26];
        for (Byte c : s.getBytes()) {
            charCount[c - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            int j = i - 1;
            while (true) {
                for (int count = 0; count < repeatLimit && charCount[i] > 0; count++) {
                    res.append((char)(i + 'a'));
                    charCount[i]--;
                }
                if(charCount[i] == 0)
                    break;
                // check this boundary out...
                // while (j > 0 && charCount[j] == 0) {
                while (j >= 0 && charCount[j] == 0) {
                    j--;
                }
                if (j < 0)
                    break;
                res.append((char)(j + 'a'));
                charCount[j]--;
            }
        }
        return res.toString();
    }
}
// @lc code=end
