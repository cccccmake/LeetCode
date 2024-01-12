/*
 * @lc app=leetcode.cn id=2085 lang=java
 *
 * [2085] 统计出现过一次的公共字符串
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countWords(String[] words1, String[] words2) {
        int count = 0;
        Map<String, Integer> rec1 = new HashMap<>();
        Map<String, Integer> rec2 = new HashMap<>();
        for (String word : words1) {
            rec1.put(word, rec1.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            rec2.put(word, rec2.getOrDefault(word, 0) + 1);
        }
        for (String key : rec1.keySet()) {
            if(rec1.get(key) == 1 && rec2.getOrDefault(key, 0) == 1)
                count++;
        }
        return count;
    }
}
// @lc code=end

