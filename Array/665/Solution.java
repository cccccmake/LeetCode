class Solution {
    public boolean checkPossibility(int[] nums) {
        if(nums.length == 0) return false;
        int count = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i - 1]){
                if(i == 1) nums[i - 1] = nums[i];
                else if(nums[i] >= nums[i - 2]) nums[i - 1] = nums[i];
                else nums[i] = nums[i - 1];
                count++;
            }
        }
        return count <= 1;
    }
}