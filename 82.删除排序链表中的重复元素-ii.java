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
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                // why only cur.next here
                // cur.next is the next node of the cur node...
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                // now cur points to the very last redandunt element, move it
                // if comment out this line, the repeated element will be kept only one
                cur = cur.next;
                // update the prev's next pointer
                prev.next = cur;
            } else {
                // otherwise, move forward...
                prev = cur;
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
}
// @lc code=end
