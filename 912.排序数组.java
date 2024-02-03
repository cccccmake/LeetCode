/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        // mergeSort(nums, 0, nums.length - 1);
        heapSort(nums);
        return nums;
    }

    /**
     * sort the area of the given array recursively
     * @param nums the given array
     * @param lo the lower bound
     * @param hi the upper bound
     */
    public void mergeSort(int[] nums, int lo, int hi){
        if(lo >= hi) return;
        // if(lo > hi) return;
        int mid = (lo + hi) >> 1;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, hi);
        return;
    }

    /**
     * merge 2 parts of the given array
     * @param nums the given array
     * @param lo lower bound
     * @param hi upper bound
     */
    public void merge(int[] nums, int lo, int hi){
        int mid = (lo + hi) >> 1;
        int i = lo, j = mid + 1, index = 0;
        int[] tmp = new int[hi - lo + 1];
        while(i <= mid && j <= hi){
            if(nums[i] < nums[j]){
                tmp[index++] = nums[i++];
            }else{
                tmp[index++] = nums[j++];
            }
        }
        while(i <= mid){
            tmp[index++] = nums[i++];
        }
        while(j <= hi){
            tmp[index++] = nums[j++];
        }
        for(int k = 0; k < hi - lo + 1; k++){
            nums[lo + k] = tmp[k];
        }
        // PLZ help the GC!
        tmp = null;
        return;
    }

    public void heapSort(int[] nums){
        int len = nums.length - 1;
        int startIdx = nums.length >> 1 - 1;
        // heapify the array
        for(int i = startIdx; i >= 0; i--){
            maxHeapify(nums, i, len);
            // motherfucker...
            // maxHeapify(nums, startIdx, len);
        }
        for(int i = len; i >= 0; i--){
            // put the largest element at the end of the array
            swap(nums, 0, i);
            // re-heapify the elements within nums[0, i - 1]
            // we got the last element in the previous step
            maxHeapify(nums, 0, i - 1);
        }
    }

    /**
     * heapify the given nums array in area [index, len]
     * @param nums
     * @param index index of the parent node
     * @param len boundary
     */
    public void maxHeapify(int[] nums, int index, int len){
        // calculate the index of the left child and the right child
        int left = index << 1 + 1;
        int right = left + 1;
        int maxIdx = left;
        // base case for recursion
        if(left > len) return;
        if(right <= len && nums[right] > nums[left])
            maxIdx = right;
        // if the parent node has exchanged with the child node
        // need to re-heapify from the exchanged child index
        if(nums[maxIdx] > nums[index]){
            swap(nums, maxIdx, index);
            maxHeapify(nums, maxIdx, len);
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

