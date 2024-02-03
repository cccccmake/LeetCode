/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null) return head;
        // ListNode fast = head --> StackOverflowError
        // consider the list A -> B -> null
        // slow = B, fast = null
        // after slow.next = null --> A -> B -> null
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode listA = mergeSort(head);
        ListNode listB = mergeSort(tmp);
        return mergeList(listA, listB);
    }
    
    public ListNode mergeList(ListNode listA, ListNode listB){
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode, currA = listA, currB = listB;
        while(currA != null && currB != null){
            if(currA.val < currB.val){
                curr.next = currA;
                currA = currA.next; 
            }else{
                curr.next = currB;
                currB = currB.next;
            }
            curr = curr.next;
        }
        if(currA != null)
            curr.next = currA;
        else
            curr.next = currB;
        return dummyNode.next;
    }
}
// @lc code=end

/*
class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head, null);
    }
    public ListNode mergeSort(ListNode head, ListNode tail){
        if(head == null) return head;
        if(head.next == tail){
            head.next = null;
            return head;
        }
        ListNode fast = head, slow = head;
        while(fast != tail){
            slow = slow.next;
            fast = fast.next;
            if(fast != tail)
                fast = fast.next;
        }
        ListNode mid = slow;
        ListNode list1 = mergeSort(head, mid);
        ListNode list2 = mergeSort(mid, tail);
        return merge(list1, list2);
    }
    public ListNode merge(ListNode left, ListNode right){
        ListNode curLeft = left, curRight = right;
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        while(curLeft != null && curRight != null){
            if(curLeft.val < curRight.val){
                curr.next = curLeft;
                curLeft = curLeft.next;
            }else{
                curr.next = curRight;
                curRight = curRight.next;
            }
            curr = curr.next;
        }
        if(curLeft != null){
            curr.next = curLeft;
        }
        if(curRight != null){
            curr.next = curRight;
        }
        return dummyNode.next;
    }
} 
 */