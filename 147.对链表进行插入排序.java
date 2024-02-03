/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode(-1, head);
        ListNode prev = dummyNode, lastSortedNode = head;
        ListNode curr = head.next;
        // ListNode curr = head;
        while(curr != null){
        // while(lastSortedNode != null){
            if(lastSortedNode.val <= curr.val){
                lastSortedNode = lastSortedNode.next;
            }
            else{
                prev = dummyNode;
                while(prev.next != null && prev.next.val < curr.val){
                    prev = prev.next;
                }
                // not here before
                lastSortedNode.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            // not here before
            curr = lastSortedNode.next;
        }
        return dummyNode.next;
    }
}
// @lc code=end

