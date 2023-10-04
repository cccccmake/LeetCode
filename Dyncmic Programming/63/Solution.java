class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dpArray = new int[m][n];
        dpArray[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i > 0 && j > 0){
                    if(obstacleGrid[i][j] == 1)
                        dpArray[i][j] = 0;
                    else{
                        dpArray[i][j] = dpArray[i - 1][j] + dpArray[i][j - 1];
                    }
                }
                else if(i > 0){
                    if(obstacleGrid[i][j] == 1)
                        dpArray[i][j] = 0;
                    else
                        dpArray[i][j] = dpArray[i - 1][j];
                }
                else if(j > 0){
                    if(obstacleGrid[i][j] == 1)
                        dpArray[i][j] = 0;
                    else
                        dpArray[i][j] = dpArray[i][j - 1];
                }
            }
        }
        return dpArray[m-1][n-1];
    }
}