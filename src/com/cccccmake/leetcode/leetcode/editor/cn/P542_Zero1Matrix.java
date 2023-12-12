package com.cccccmake.leetcode.leetcode.editor.cn;

//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// mat[i][j] is either 0 or 1. 
// mat 中至少有一个 0 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 897 👎 0

/**
 * 01 矩阵
 *
 * @author cccccmake
 */
public class P542_Zero1Matrix{
    public static void main(String[] args) {
        Solution solution = new P542_Zero1Matrix().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if (mat[i][j] == 0) {
                    continue;
                }else{
                    if(i > 0 && i < row - 1 && j > 0 && j < column - 1){
                        if(mat[i][])
                    }else {
                        if (i == 0) {

                        } else if (i == row - 1) {

                        }
                        if (j == 0) {

                        } else if (j == column - 1) {

                        }
                    }
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}