import java.util.Arrays;

class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int[] count = new int[10001];
        for(int i = 0; i < nums.length; i++)
            count[nums[i]]++;
        int[] dpArray = new int[10001];
        dpArray[i] = Math.max(dpArray[i - 1], dpArray[i + 1]) + i * count[i]
    }
}