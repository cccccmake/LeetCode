class Solution {
    public int countSubstrings(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for(int i = 0; i < length; i++)
            dp[i][i] = true;
        for(int L = 2; L <= length; L++){
            for(int left = 0; left < length; left++){
                int right = left + L - 1;
                if(right >= length)
                    break;
                if(L == 2){
                    if(s.charAt(right) == s.charAt(left))
                        dp[left][right] = true;
                }else{
                    dp[left][right] = dp[left + 1][right - 1] && s.charAt(left) == s.charAt(right);
                }    
            }
        }
        int count = 0;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                if(dp[i][j] == true)
                    count++;
            }
        }
        return count;
    }
}