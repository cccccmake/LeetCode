package com.cccccmake.leetcode.leetcode.editor.cn;

//一个机器人位于一个
// m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
// 
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
// 
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1186 👎 0

/**
 * 不同路径 II
 *
 * @author cccccmake
 */
public class P63_UniquePathsIi{
    public static void main(String[] args) {
        Solution solution = new P63_UniquePathsIi().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] dpArray = new int[row][column];
        // init column
        for(int i = 0; i < row; i++){
            if(obstacleGrid[i][0] == 1){
                for(int j = i; j < row; j++){
                    dpArray[i][0] = 0;
                }
                break;
            }else{
                dpArray[i][0] = 1;
            }
        }
        // init row
        for(int i = 0; i < column; i++){
            if(obstacleGrid[0][i] == 1){
                for(int j = i; j < column; j++){
                    dpArray[0][j] = 0;
                }
                break;
            }else{
                dpArray[0][i] = 1;
            }
        }
        for(int i = 1; i < row; i++){
            for(int j = 1; j < column; j++){
                if(obstacleGrid[i][j] == 1){
                    continue;
                }
                else {
                    dpArray[i][j] = dpArray[i - 1][j] + dpArray[i][j - 1];
                }
            }
        }
        return dpArray[row - 1][column - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}