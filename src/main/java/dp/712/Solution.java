class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int res = 0;
        // s1 || s2 size is 0
        if(s1.length() == 0){
            for(int i = 0; i < s2.length(); i++)
                res += calAscii(s2.charAt(i));
            return res;
        }else if(s2.length() == 0){
            for(int i = 0; i < s1.length(); i++)
                res += calAscii(s1.charAt(i));
            return res;
        }
        int row = s1.length();
        int column = s2.length();
        int[][] dp = new int[row+1][column+1];
        String[][] toDelete = new String[row+1][column+1];
        dp[0][0] = 0;
        toDelete[0][0] = "0";
        
        for(int i = 1; i < row + 1; i++){
            dp[i][0] = dp[i - 1][0] + calAscii(s1.charAt(i - 1));
            toDelete[i][0] = s1.substring(0, i);
        }

        for(int i = 1; i < column + 1; i++){
            dp[0][i] = dp[0][i - 1] + calAscii(s2.charAt(i - 1));
            toDelete[0][i] = s2.substring(0, i);
        }

        for(int i = 1; i < row + 1; i++){
            for(int j = 1; j < column + 1; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                    toDelete[i][j] = toDelete[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.min(dp[i - 1][j] + calAscii(s1.charAt(i - 1)), dp[i][j - 1] + calAscii(s2.charAt(j - 1)));
                    toDelete[i][j] = dp[i - 1][j] + calAscii(s1.charAt(i - 1)) < dp[i][j - 1] + calAscii(s2.charAt(j - 1)) ? toDelete[i - 1][j] + s1.charAt(i - 1) : toDelete[i][j - 1] + s2.charAt(j - 1);
                }
            }
        }
        for(int i = 0; i < row + 1; i++){
            for(int j = 0; j < column + 1; j++){
                System.out.print(toDelete[i][j]);
                System.out.print(' ');
            }
            System.out.println();
            System.out.println();
        }
        return dp[row][column];
    }

    public static int calAscii(char ch){
        int ascii = ch;
        return ascii;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumDeleteSum("sea", "eat");
    }
}