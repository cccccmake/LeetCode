import java.util.Arrays;

class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dpArray = new int[grid.length][grid[0].length];
        dpArray[0][0] = grid[0][0];
        int sum = dpArray[0][0];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(i > 0 && j > 0)
                    dpArray[i][j] = Math.min(grid[i][j] + dpArray[i - 1][j], grid[i][j] + dpArray[i][j - 1]);
                else if(i > 0)
                    dpArray[i][j] = grid[i][j] + dpArray[i - 1][j];
                else if(j > 0)
                    dpArray[i][j] = grid[i][j] + dpArray[i][j - 1];
            }
        }
        return dpArray[grid.length - 1][grid[0].length - 1];
    }
}