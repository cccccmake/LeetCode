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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // init a dummy head, make it point at the head
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        // init the fast- and slow-pointer
        ListNode fastPtr = dummyHead;
        ListNode slowPtr = dummyHead;
        // move the fastPtr n steps forward first
        while(n != 0 && fastPtr.next != null) {
            fastPtr = fastPtr.next;
            n--;
        }
        while (fastPtr.next != null){
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = slowPtr.next.next;
        return dummyHead.next;
    }
}