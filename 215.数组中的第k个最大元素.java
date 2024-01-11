/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start

import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // using a minimal heap to store the top-k elements
        for(int i = 0; i < k; i++){
            minHeap.offer(nums[i]);
        }

        for(int i = k; i < nums.length; i++){
            // the top elemtn of the heap is the smallest one among k elements
            int heapElem = minHeap.peek();
            // if current element < nums[i], remove the current element and insert
            // nums[i] into the heap
            if(heapElem < nums[i]){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
// @lc code=end

