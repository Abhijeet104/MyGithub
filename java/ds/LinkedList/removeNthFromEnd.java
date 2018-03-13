/* Problem
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

**/



/**
 * Defition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode temp = head;
        if(head == null)
            return null;
        while(n > 0){
            temp = temp.next;
            n--;
        }
        
        if(temp == null){
            //remove first node
            head = head.next;
            return head;
        }
        while(temp.next != null){
            temp = temp.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
        
        
    }
    
}
