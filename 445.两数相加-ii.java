/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
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
    // reverse a list
    public ListNode reverseList(ListNode start){
        ListNode dummyNode = null;
        ListNode pre = dummyNode, cur = start;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reversedList1 = reverseList(l1);
        ListNode reversedList2 = reverseList(l2);
        ListNode res = addTwoNumbersOriginal(reversedList1, reversedList2);
        return reverseList(res);
    }
    // original solution towards question 2.
    public ListNode addTwoNumbersOriginal(ListNode l1, ListNode l2) {
        ListNode resDummyNode = new ListNode(-1);
        ListNode curNode = resDummyNode;
        int carryBit = 0;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                curNode.next = new ListNode((l1.val + l2.val + carryBit) % 10);
                if(l1.val + l2.val + carryBit >= 10) carryBit = 1;
                // DON'T forget reset carryBit!
                else carryBit = 0;
                l1 = l1.next;
                l2 = l2.next;
            }else if(l1 != null){
                curNode.next = new ListNode((l1.val + carryBit) % 10);
                if(l1.val + carryBit >= 10) carryBit = 1;
                else carryBit = 0;
                l1 = l1.next;
            }else{
                curNode.next = new ListNode((l2.val + carryBit) % 10);
                if(carryBit + l2.val >= 10) carryBit = 1;
                else carryBit = 0;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }
        if(carryBit != 0){
            curNode.next = new ListNode(carryBit);
            curNode = curNode.next;
            curNode.next = null;
        }
        return resDummyNode.next;
    }
}
// @lc code=end

