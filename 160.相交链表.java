/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode res = null;
        ListNode headAMoving = headA;
        ListNode headBMoving = headB;
        int lenA = 0;
        int lenB = 0;
        // calculate the length of 2 list
        while (headAMoving != null) {
            lenA++;
            headAMoving = headAMoving.next;
        }
        while (headBMoving != null) {
            lenB++;
            headBMoving = headBMoving.next;
        }
        // calculate the difference
        int diff = (int) Math.abs(lenA - lenB);
        headAMoving = headA;
        headBMoving = headB;
        // move the head ptr of the longer list difference-step forward
        if (lenA > lenB) {
            while (diff-- > 0) {
                headAMoving = headAMoving.next;
            }
        } else if (lenA < lenB) {
            while (diff-- > 0) {
                headBMoving = headBMoving.next;
            }
        }
        // search the common node 
        while (headAMoving != null && headBMoving != null) {
            if (headAMoving == headBMoving) {
                res = headAMoving;
                return res;
            } else {
                headAMoving = headAMoving.next;
                headBMoving = headBMoving.next;
            }
        }
        return res;
    }
}
// @lc code=end
