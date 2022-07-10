class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> record = new HashMap<>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(record.get(nums[i]) != null)
                return true;
            else
                record.put(nums[i], 1);
        }
        return false;
    }
}
