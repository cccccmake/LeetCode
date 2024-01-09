/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dequeue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // init the dequeue for the 1st window
        // elem[0] >= elem[1] >= ...  >= elem[n - 1]
        for(int i = 0; i < k; i++){
            while(!dequeue.isEmpty() && dequeue.peekLast() < nums[i])
                dequeue.removeLast();
            dequeue.addLast(nums[i]);
        }
        res[0] = dequeue.peekFirst();
        for(int i = k; i < nums.length; i++){
            // why this fuck?
            // avoid repeatedly use nums[i - k]
            // as it has already been moved out of the window
            if(dequeue.peekFirst() == nums[i - k])
                dequeue.removeFirst();
            while(!dequeue.isEmpty() && dequeue.peekLast() < nums[i])
                dequeue.removeLast();
            dequeue.addLast(nums[i]);
            res[i - k + 1] = dequeue.peekFirst();
        }
        return res;
    }
}
// @lc code=end

