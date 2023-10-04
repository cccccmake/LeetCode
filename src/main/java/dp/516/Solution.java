class Solution {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        if(length == 1) return 1;
        int[][] dp = new int[length][length];
        char[] charArray = s.toCharArray();

        for(int i = 0; i < length; i++)
            dp[i][i] = 1;

        for(int L = 2; L <= length; L++){
            for(int i = 0; i < length; i++){
                int j = i + L - 1;
                if(j >= length)
                    break;
                if(L == 2)
                    dp[i][j] = charArray[i] == charArray[j] ? 2 : 1;
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    if(charArray[i] == charArray[j])
                        dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
            }
        }
        return dp[0][length - 1];
    }
}