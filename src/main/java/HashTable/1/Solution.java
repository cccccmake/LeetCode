class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> rec = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            // Why this can not be placed here?
            // rec.put(nums[i], i);
            // For example, test case [3,2,4] 6
            // What happens here: newtarget is 6-3, 3 is already in rec, but it should not be uesd.
            // To avoid using an element freshly put into the rec, update the rec after looking for the newtarget
            int newtarget = target - nums[i];
            if(rec.containsKey(newtarget))
                return new int[]{rec.get(newtarget), i};
            rec.put(nums[i], i);
        }
        return new int[2]{0, 0};
    }
}