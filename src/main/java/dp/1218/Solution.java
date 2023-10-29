import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        // int[] dp = new int[arr.length];
        // Arrays.fill(dp, 1);
        // int res = 0;
        // for(int i = 0; i < arr.length; i++){
        //     for(int j = 0; j < i; j++){
        //         if(arr[i] - arr[j] == difference)
        //             dp[i] = Math.max(dp[i], dp[j] + 1);
        //     }
        //     res = Math.max(dp[i], res);
        // }
        // return res;
        int res = 0;
        Map<Integer, Integer> dp = new HashMap<>();
        for(int value : arr){
            dp.put(value, dp.getOrDefault(value - difference, 0) + 1);
            res = Math.max(res, dp.get(value));
        }
        return res;
    }
}