/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while(headA != null){
            lenA++;
            headA = headA.next;
        }
        while(headB != null){
            lenB++;
            headB = headB.next;
        }
        int gap;
        if(lenA > lenB) gap = lenA - lenB;
        else{
            // why should it be so complicated here?
            gap = lenB - lenA;
            ListNode tmp = curA;
            curA = curB;
            curB = tmp;
        }

        while(gap-- > 0){
            // otherwise you must make things complex here
            curA = curA.next;
        }

        while(curA != null){
            if(curA == curB) return curA;
            else{
                curA = curA.next;
                curB = curB.next;
            }
        }
        return null;
    }
}