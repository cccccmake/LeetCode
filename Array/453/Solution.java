import java.util.Arrays;

class Solution {
    public int minMoves(int[] nums) {
        int minVal =  Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for(int item : nums)
            res += item - minVal;

        return res;
    }
}