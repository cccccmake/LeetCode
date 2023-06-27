class Solution {
    public int[][] generateMatrix(int n) {
        int startX = 0;
        int startY = 0;
        int count = 1;
        int loop = n / 2;
        int mid = n / 2;
        int offset = 1;
        int i, j;
        int[][] res = new int[n][n];
        // right downwards left upwards
        while(loop > 0){
            for(j = startY; j < n - offset; j++)
                res[startX][j] = count++;
            for(i = startX; i < n - offset; i++)
                res[i][j] = count++;
            for(; j > startY; j--)
                res[i][j] = count++;
            for(; i > startX; i--)
                res[i][j] = count++;
            startX++;
            startY++;
            offset++;
            loop--;
        }
        if(n % 2 != 0)
            res[mid][mid] = count;
        return res;
    }
}