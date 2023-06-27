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
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1, head);
        ListNode current = head;
        ListNode previous = fakeHead;
        while(current != null){
            if(current.val == val)
                previous.next = current.next;
            else{
                previous = current;
            }
            current = current.next;
        }
        return fakeHead.next;
    }
}