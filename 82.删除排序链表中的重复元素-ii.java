/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode, cur = head, nxt = cur.next;
        // as we're accessing values from cur and nxt
        // therefore they cannot be null
        while (cur != null && nxt != null) {
            if (cur.val == nxt.val) {
                // find the 1st elem that differs to cur.val
                while (nxt != null && cur.val == nxt.val) {
                    nxt = nxt.next;
                }
                // update prev, cur, and nxt
                cur = nxt;
                prev.next = cur;
                // avoid NullPointerException here
                if (nxt == null)
                    break;
                else
                    nxt = nxt.next;
            } else {
                // no same element, update as normal, 1 step forward
                prev = cur;
                cur = nxt;
                nxt = nxt.next;
            }
        }
        return dummyNode.next;
    }
}
// @lc code=end
