class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftBoundary = findLeftBoundary(nums, target, 0, nums.length-1);
        int rightBoundary = findRightBoundary(nums, target, 0, nums.length-1);
        int[] res = {-1, -1};
        if(leftBoundary == -2 || rightBoundary == -2) return res;
        else if(rightBoundary - leftBoundary > 1){
            res[0] = leftBoundary + 1;
            res[1] = rightBoundary - 1;
            return res;
        }
        else return res;
    }
    public static int findLeftBoundary(int[] nums, int target, int left, int right){
        int leftBoundary = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // when you can not figure out what to do next,
            // consider another branch would be a good idea
            if (nums[mid] >= target) {
                right = mid - 1;
                leftBoundary = right;
            } else {
                // current element is smaller than target
                // update left
                left = mid + 1;
            }
        }
        return leftBoundary;
    }

    public static int findRightBoundary(int[] nums, int target, int left, int right){
        int rightBoundary = -2;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target){
                left = mid + 1;
                rightBoundary = left;
            }else{
                // current element is larger than target
                // update right
                right = mid - 1;
            }
        }
        return rightBoundary;
    }
}