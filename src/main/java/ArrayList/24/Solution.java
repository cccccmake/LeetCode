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
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode current = dummyHead;
        while(current.next != null && current.next.next != null){
            ListNode tmp1 = current.next;
            ListNode tmp2 = current.next.next.next;
            current.next = current.next.next;
            current.next.next = tmp1;
            // this is incorrect
            // tmp1.next = tmp2.next;
            current.next.next.next = tmp2;
            current = tmp1;
        }
        return dummyHead.next;
    }
}