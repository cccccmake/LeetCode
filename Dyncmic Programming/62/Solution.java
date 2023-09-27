class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dpArray = new int[m][n];
        dpArray[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                if(i > 0 && j > 0)
                    dpArray[i][j] = dpArray[i-1][j] + dpArray[i][j-1];
                    // must i comes first, then j
                else if(i == 0)
                    dpArray[i][j] = dpArray[i][j-1];
                else if(j == 0)
                    dpArray[i][j] = dpArray[i - 1][j];
            }
        }
        return dpArray[m - 1][n - 1];
    }
}