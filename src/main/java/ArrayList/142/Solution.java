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
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next!= null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr){
                ListNode newStart = head;
                while(newStart != slowPtr){
                    newStart = newStart.next;
                    slowPtr = slowPtr.next;
                }
                return slowPtr;
            }
        }
        return null;
    }
}

/*
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next!= null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr)
                break;
        }
        // fuck it
        // if(slowPtr != fastPtr)
        // You need to consider the situation that a linked list has NO ring
        if(slowPtr != fastPtr || fastPtr == null || fastPtr.next == null)
            return null;
        ListNode newStart = head;
        while(newStart != slowPtr){
            // fuck it
            // head = head.next;
            newStart = newStart.next;
            slowPtr = slowPtr.next;
        }
        return newStart;
    }
}
*/