class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        for(; fast < nums.length; fast++){
            while(fast < nums.length && nums[fast] == nums[slow])
                fast++;
            if(fast < nums.length)
                nums[++slow] = nums[fast];
        }
        return slow+1;
    }
}