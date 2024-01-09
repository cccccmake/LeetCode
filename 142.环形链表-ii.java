/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        // why this fcking condition?
        // cause we're accessing fast.next.next
        // [fast.next] => fast != null
        // [fast.next.next] => fast.next != null
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            // The 1st time that fast ptr meets slow ptr
            // distance_f = 2 * distance_s (faster++ vs. slow+)
            // as they MUST meet inside the cycle (b nodes), we have => distance_f = distance_s + n * b
            // therefore distance_s = n * b
            if(fast == slow)
                break;
        }
        // has reached the end of the list
        if(fast == null || fast.next == null) return null;
        else{
            fast = head;
            while(fast != slow){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
}
// @lc code=end

