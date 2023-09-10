class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int item : nums)
            sum += item;
        if(sum % 2 == 1) return false;
        int target = sum / 2;
        int maxTarget = 10001;
        int[] dpArray = new int[maxTarget];
        for(int i = 0; i < nums.length; i++){
            for(int j = target; j >= nums[i]; j--){
                dpArray[j] = Math.max(dpArray[j], dpArray[j - nums[i]] + nums[i]);
            }
        }
        if(dpArray[target] == target)
            return true;
        return false;
    }
}