class Solution {
    public int numDistinct(String s, String t) {
        if(s.length() < t.length()) return 0;
        int row = s.length();
        int column = t.length();
        int[][] dp = new int[row + 1][column + 1];
        for(int i = 0; i < row + 1; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= column; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // for(int i = 0; i < row + 1; i++){
        //     for(int j = 0; j < column + 1; j++){
        //         System.out.print(dp[i][j]);
        //         System.out.print(' ');
        //     }
        //     System.out.println();
        //     System.out.println();
        // }
        return dp[row][column];
    }

    // public static void main(String[] args) {
    //     Solution sol = new Solution();
    //     sol.numDistinct("rabbbit", "rabbit");
    // }
}