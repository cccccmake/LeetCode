/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int height = word1.length();
        int width = word2.length();
        // dpArray[i][j] => word1[0, i - 1]到word2[0, j - 1]的最小编辑距离
        int[][] dpArray = new int[height + 1][width + 1];
        for(int i = 0; i <= height; i++) dpArray[i][0] = i;
        for(int i = 0; i <= width; i++) dpArray[0][i] = i;
        // start dp process
        for(int i = 1; i <= height; i++){
            for(int j = 1; j <= width; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dpArray[i][j] = dpArray[i - 1][j - 1];
                }else{
                    dpArray[i][j] = Math.min(dpArray[i - 1][j], Math.min(dpArray[i][j - 1], dpArray[i - 1][j - 1])) + 1;
                }
            }
        }
        return dpArray[height][width];
    }
}
// @lc code=end

