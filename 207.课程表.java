/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> rec = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            rec.put(prerequisites[i][1], rec.getOrDefault(prerequisites[i][0], -1));
        }
        for(int i = 0; i < numCourses; i++){
            if(rec.getOrDefault(i, -1) != -1)
                return false;
        }
        return true;
    }
}
// @lc code=end

