class BruteSolution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum >= target){
                    res = j - i + 1 < res ? j - i + 1 : res;
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int lowBoundary = 0;
        int highBoundary = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for(; highBoundary < nums.length; highBoundary++) {
            sum += nums[highBoundary];
            while(sum >= target) {
                res = res < highBoundary - lowBoundary + 1 ? res : highBoundary - lowBoundary + 1;
                sum -= nums[lowBoundary++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}