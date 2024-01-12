/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] mergeArray = new int[length];
        int idx1 = 0, idx2 = 0, index = 0;
        while(idx1 < nums1.length && idx2 < nums2.length){
            if(nums1[idx1] <= nums2[idx2]){
                mergeArray[index++] = nums1[idx1++];
            }else{
                mergeArray[index++] = nums2[idx2++];
            }
        }
        if(idx1 == nums1.length){
            while(idx2 < nums2.length){
                mergeArray[index++] = nums2[idx2++];
            }
        }else if(idx2 == nums2.length){
            while(idx1 < nums1.length){
                mergeArray[index++] = nums1[idx1++];
            }
        }
        if(length % 2 == 1){
            return (double)mergeArray[length / 2];
        }else{
            return (mergeArray[length/2 - 1] + mergeArray[length/2]) / 2.0;
        }
    }
}
// @lc code=end

