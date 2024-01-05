/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++){
            int newTarget = target - numbers[i];
            int left = i + 1;
            int right = numbers.length - 1;
            while(left <= right){
                int mid = (left + right) >> 1;
                if(numbers[mid] == newTarget){
                    return new int[]{i + 1, mid + 1};
                }else if(numbers[mid] < newTarget){
                    left = mid + 1;
                }else if(numbers[mid] > newTarget){
                    right = mid - 1;
                }
            }
        }
        return new int[] {-1, -1};
    }
}
// @lc code=end

