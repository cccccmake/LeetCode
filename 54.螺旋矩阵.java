/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        // check out this motherfucker => endX and endY
        int startX = 0, startY = 0, endX = height - 1, endY = width - 1;
        while (startX < endX && startY < endY) {
            for (int i = startY; i < endY; i++)
                res.add(matrix[startX][i]);
            for (int i = startX; i < endX; i++)
                res.add(matrix[i][endY]);
            for (int i = endY; i > startY; i--)
                res.add(matrix[endX][i]);
            for (int i = endX; i > startX; i--)
                res.add(matrix[i][startY]);
            startY++;
            startX++;
            endY--;
            endX--;
        }
        // what's left might be:
        // 1. startX == endX -> single row
        // 2. startY == endY -> single column
        // 3. startX == endX && startY == endY -> single element
        // why "else-if" instead of a simple "if{} if{}"
        // if there is only ONE element left to visit
        // it will be visited TWICE if we use if-if
        if (startX == endX) {
            for (int i = startY; i <= endY; i++)
                res.add(matrix[startX][i]);
        }else if (startY == endY) {
            for (int i = startX; i <= endX; i++)
                res.add(matrix[i][startY]);
        }
        return res;
    }
}
// @lc code=end
