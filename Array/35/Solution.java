class Solution {
    public int searchInsert(int[] nums, int target) {
        int res = 0;
        if(nums[0] > target) return 0;
        else if(nums[nums.length - 1] < target) return nums.length;
        else return binarySearch(nums, target, 0, nums.length);
    }
    public int binarySearch(int[] nums, int target, int lo, int hi){
        if(lo == hi) return lo;
        int mid = lo + (hi - lo) / 2;
        if(nums[mid] == target) return mid;
        else if(nums[mid] > target) return binarySearch(nums, target, lo, mid);
        else return binarySearch(nums, target, mid+1, nums.length);
    }
}