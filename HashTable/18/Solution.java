class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // why this fuck goes wrong?
        // if(nums[0] > target) return res;
        // consider the nums[0] is negative and we want a smaller target
        // e.g., nums[0] = -5, target = -6
        for(int i = 0; i < nums.length; i++){
            // if(nums[i] > 0 && nums[i] > target) return res;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1; j < nums.length; j++){
                // This fuck goes wrong
                // if(nums[i] + nums[j] > target) return res;
                // The same reason as the previous fuck
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right){
                    // need to consider the overflow
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum > target)
                        right--;
                    else if(sum < target)
                        left++;
                    else{
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left+1]) left++;
                        while(left < right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}